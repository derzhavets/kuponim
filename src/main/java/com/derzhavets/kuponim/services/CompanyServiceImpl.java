package com.derzhavets.kuponim.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyDao;
import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.entities.Income;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.IncomeType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CouponDao couponDao;

	@Autowired
	private IncomeConnectorService incomeService;
	
	@Override
	public Client login(String email, String password) 
			throws UserNotFoundException {
		companyDao.checkCompanyUser(email, password);
		return this;
	}

	@Override
	public Coupon createCoupon(Coupon coupon, Long companyId) throws EntityNotFoundException {
		Company company = companyDao.getById(companyId);
		coupon.setCompany(company);
		couponDao.save(coupon);
		System.err.println(coupon);
		company.getCoupons().add(coupon);
		companyDao.save(company);
		
		Income income = new Income(company.getEmail(), IncomeType.COMPANY_NEW_COUPON, 10.0);
		incomeService.sendIncome(income);
		
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
		return new ArrayList<Coupon>(companyDao.getById(companyId).getCoupons());
	}

	@Override
	public List<Coupon> getCouponsByType(Long companyId, CouponType type) 
			throws EntityNotFoundException {
		return companyDao.getById(companyId).getCoupons().stream()
				.filter(c -> c.getType().equals(type))
				.collect(Collectors.toList());
	}
	
}
