package com.derzhavets.kuponim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class SystemService {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	public Client login(String name, String password, ClientType clientType) 
			throws UserNotFoundException {

		Client client;
		switch (clientType) {
			case ADMIN:
				client = adminService.login(name, password, clientType);
				break;
			case COMPANY:
				client = companyService.login(name, password, clientType);
				break;
			case CUSTOMER:
				client = customerService.login(name, password, clientType);
				break;
			default:
				client = null;
		}
		return client;
	}
	
	
	
}
