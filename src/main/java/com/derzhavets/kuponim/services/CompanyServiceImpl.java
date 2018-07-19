package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;

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
	public Company getById(Long id) throws EntityNotFoundException {
		return companyDao.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Company with id " + id + " is not found"));
	}

	@Override
	public Company delete(Long id) throws EntityNotFoundException {
		Company company = getById(id);
		companyDao.delete(company);
		return company;
	}
	
}
