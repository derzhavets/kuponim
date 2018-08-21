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
	
	/**
	 * Get all the companies registered in the system
	 * 
	 * @return list of company entities found in the database
	 */
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	/**
	 * Pass company entity to be saved to the company repository
	 * 
	 * @param company to be saved
	 * @return saved company entity
	 */
	public Company save(Company company) {
		return companyRepository.save(company);
	}
	
	/**
	 * Retrieve company entity based on company id
	 * 
	 * @param id of the company to be retieved from the database
	 * @return found company entity
	 * @throws EntityNotFoundException in case company with received id is not found in the 
	 * database
	 */
	public Company getById(Long id) throws EntityNotFoundException {
		return companyRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Company with id " + id + " is not found"));
	}
	
	/**
	 * Delete company entity based on company id
	 * 
	 * @param id of the company to be deleted from the database
	 * @return deleted company entity
	 * @throws EntityNotFoundException in case company with received id is not found in the 
	 * database
	 */
	public Company delete(Long id) throws EntityNotFoundException {
		Company company = getById(id);
		companyRepository.delete(company);
		return company;
	}
	
	/**
	 * Looking for a company entity in the database matching received credentials to perform
	 * company user authentication
	 * 
	 * @param email of the company user
	 * @param password of the company user
	 * @return KuponimUser entity with found company credentials
	 * @throws UserNotFoundException in case there were no company found in the database with
	 * provided credentials
	 */
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
