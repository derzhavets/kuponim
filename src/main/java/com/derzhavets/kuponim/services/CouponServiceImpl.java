package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyRepository;
import com.derzhavets.kuponim.dao.CouponRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponDao;
	
	@Autowired
	private CompanyRepository companyDao;
	
	@Autowired
	private CompanyService companyService;
	
	@Override
	public List<Coupon> getAll() {
		return couponDao.findAll();
	}
	
	
	@Override
	public Coupon save(Coupon coupon, Long companyId) throws EntityNotFoundException {
		Company company = companyService.getById(companyId);
		coupon.setCompany(company);
		couponDao.save(coupon);
		company.getCoupons().add(coupon);
		companyDao.save(company);
		return coupon;
	}

	@Override
	public Coupon getById(Long id) throws EntityNotFoundException {
		return couponDao.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Coupon with id " + id + " is not found."));
	}

	@Override
	public Coupon delete(Long id) throws EntityNotFoundException {
		Coupon coupon = getById(id);
		couponDao.delete(coupon);
		return coupon;
	}
 
}
