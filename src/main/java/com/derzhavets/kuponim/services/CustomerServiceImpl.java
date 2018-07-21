package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Client login(String name, String password, ClientType clientType) 
			throws UserNotFoundException {
		customerDao.checkCustomerUser(name, password);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#purchaseCoupon()
	 */
	@Override
	public Coupon purchaseCoupon(Coupon coupon, Long customerId) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAllPurchasedCoupons()
	 */
	@Override
	public List<Coupon> getAllPurchasedCoupons() {
		return couponDao.getAll();
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAllPurchasedCouponsByType(com.derzhavets.kuponim.helpers.CouponType)
	 */
	@Override
	public List<Coupon> getAllPurchasedCouponsByType(CouponType type) {
		return null;
	}

}
