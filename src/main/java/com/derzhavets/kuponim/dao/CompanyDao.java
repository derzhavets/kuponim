package com.derzhavets.kuponim.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CompanyRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;

@Service
public class CompanyDao {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CompanyService#getAll()
	 */
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}
	
	public Company getById(Long id) throws EntityNotFoundException {
		return companyRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Company with id " + id + " is not found"));
	}

	public Company delete(Long id) throws EntityNotFoundException {
		Company company = getById(id);
		companyRepository.delete(company);
		return company;
	}
	
	public void checkCompanyUser(String name, String password) throws UserNotFoundException {
		List<Company> companies = companyRepository.findByNameAndPassword(name, password);
		if (companies.isEmpty()) 
			throw new UserNotFoundException("Company name or password is incorrect.");
	}

}
