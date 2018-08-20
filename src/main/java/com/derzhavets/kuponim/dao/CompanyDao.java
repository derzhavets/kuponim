package com.derzhavets.kuponim.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CompanyRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

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
	
	public KuponimUser getCompanyUser(String email, String password) throws UserNotFoundException {
		List<Company> companies = companyRepository.findByEmailAndPassword(email, password);
		if (companies.isEmpty()) {
			throw new UserNotFoundException("Company email or password is incorrect.");
		} else {
			Company company = companies.get(0);
			return new KuponimUser(company.getId(), company.getName(), company.getEmail(), ClientType.COMPANY);
		}
	}

}
