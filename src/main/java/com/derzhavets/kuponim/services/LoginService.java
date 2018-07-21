package com.derzhavets.kuponim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.login.Client;

@Service
public class LoginService {
	
	@Autowired
	private AdminService adminService;
	
	public Client login() {
		return adminService;
	}
	
	
	
}
