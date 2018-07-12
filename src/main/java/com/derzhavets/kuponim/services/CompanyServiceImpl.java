package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyRepository;
import com.derzhavets.kuponim.entities.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyDao;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CompanyService#getAll()
	 */
	@Override
	public List<Company> getAll() {
		return companyDao.findAll();
	}

	@Override
	public Company save(Company company) {
		return companyDao.save(company);
	}
	
	@Override
	public Company getById(Long id) throws Exception {
		return companyDao.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public void delete(Long id) {
		companyDao.deleteById(id);
	}
	
}
