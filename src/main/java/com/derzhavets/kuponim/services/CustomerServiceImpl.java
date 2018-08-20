package com.derzhavets.kuponim.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.aspect.ReportIncome;
import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.IncomeType;
import com.derzhavets.kuponim.helpers.exceptions.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public KuponimUser login(String email, String password) throws UserNotFoundException {
		return customerDao.getCustomerUser(email, password);
	}
	
	@Override
	@ReportIncome(type = IncomeType.CUSTOMER_PURCHASE)
	public Coupon purchaseCoupon(Long customerId, Long couponId) 
			throws EntityNotFoundException, CouponTypeNotAllowedException {
		
		Coupon coupon = couponDao.getById(couponId);
		Customer customer = customerDao.getById(customerId);
		if (!customer.getCoupons().add(coupon))
			throw new CouponTypeNotAllowedException("Coupon of type " + coupon.getType() +
					" already purchased for customer id=" + customerId);
		coupon.setAmount(coupon.getAmount() - 1);
		customerDao.save(customer);
		return coupon;
	}
	

	@Override
	public List<Coupon> getAllPurchasedCoupons(Long customerId) throws EntityNotFoundException {
		return new ArrayList<Coupon>(customerDao.getById(customerId).getCoupons());
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAllPurchasedCouponsByType(com.derzhavets.kuponim.helpers.CouponType)
	 */
	@Override
	public List<Coupon> getAllPurchasedCouponsByType(Long customerId, CouponType type) throws EntityNotFoundException {
		return getAllPurchasedCoupons(customerId).stream()
				.filter(c -> c.getType().equals(type))
				.collect(Collectors.toList());
	}

	@Override
	public List<Coupon> getAllCoupons() {
		return couponDao.getAll();
	}
	
}
