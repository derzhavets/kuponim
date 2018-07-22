package com.derzhavets.kuponim.services;

import java.util.List;
import java.util.stream.Collectors;

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
	public Coupon removeCoupon(Long couponId) throws EntityNotFoundException {
		return couponDao.delete(couponId);
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		return couponDao.save(coupon);
	}

	@Override
	public Coupon getCoupon(Long couponId) throws EntityNotFoundException {
		return couponDao.getById(couponId);
	}

	@Override
	public List<Coupon> getAllCoupons(Long companyId) throws EntityNotFoundException {
		return (List<Coupon>) companyDao.getById(companyId).getCoupons();
	}

	@Override
	public List<Coupon> getCouponsByType(Long companyId, CouponType type) 
			throws EntityNotFoundException {
		return companyDao.getById(companyId).getCoupons().stream()
				.filter(c -> c.getType().equals(type))
				.collect(Collectors.toList());
	}
	
}
