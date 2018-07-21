package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyDao;
import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CouponDao couponDao;

	@Override
	public Client login(String name, String password, ClientType clientType) 
			throws UserNotFoundException {
		companyDao.checkCompanyUser(name, password);
		return this;
	}

	@Override
	public Coupon createCoupon(Coupon coupon, Long companyId) throws EntityNotFoundException {
		Company company = companyDao.getById(companyId);
		coupon.setCompany(company);
		couponDao.save(coupon);
		company.getCoupons().add(coupon);
		companyDao.save(company);
		return coupon;
	}

	@Override
	public Coupon removeCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCoupon(Long id) throws EntityNotFoundException {
		return couponDao.getById(id);
	}

	@Override
	public List<Coupon> getAllCoupons(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getCouponsByType(Long companyId, CouponType type) {
		return null;
	}
	
}
