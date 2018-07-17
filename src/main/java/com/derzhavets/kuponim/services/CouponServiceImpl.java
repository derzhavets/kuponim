package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyRepository;
import com.derzhavets.kuponim.dao.CouponRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponDao;
	
	@Autowired
	private CompanyRepository companyDao;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CouponService#getAll()
	 */
	@Override
	public List<Coupon> getAll() {
		return couponDao.findAll();
	}

	@Override
	public Coupon save(Coupon coupon, Long companyId) {
		Company company = companyDao.findById(companyId).get();
		coupon.setCompany(company);
		couponDao.save(coupon);
		company.getCoupons().add(coupon);
		companyDao.save(company);
		return coupon;
	}

	@Override
	public Coupon getById(Long id) throws Exception {
		return couponDao.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public void delete(Long id) {
		couponDao.deleteById(id);
	}
 
}
