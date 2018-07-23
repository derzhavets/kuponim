package com.derzhavets.kuponim.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Client login(String name, String password) 
			throws UserNotFoundException {
		customerDao.checkCustomerUser(name, password);
		return this;
	}
	
	@Override
	public Coupon purchaseCoupon(Long customerId, Long couponId) 
			throws EntityNotFoundException, CouponTypeNotAllowedException {
		Coupon coupon = couponDao.getById(couponId);
		Customer customer = customerDao.getById(customerId);
		if (!customer.getCoupons().add(coupon))
			throw new CouponTypeNotAllowedException("Coupon of type " + coupon.getType() +
					" already purchased for customer id=" + customerId);
		customerDao.save(customer);
		return coupon;
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAllPurchasedCoupons()
	 */
	@Override
	public List<Coupon> getAllPurchasedCoupons(Long customerId) {
		return new ArrayList<Coupon>(customerDao.getById(customerId).getCoupons());
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAllPurchasedCouponsByType(com.derzhavets.kuponim.helpers.CouponType)
	 */
	@Override
	public List<Coupon> getAllPurchasedCouponsByType(Long customerId, CouponType type) {
		return getAllPurchasedCoupons(customerId).stream()
				.filter(c -> c.getType().equals(type))
				.collect(Collectors.toList());
	}

}
