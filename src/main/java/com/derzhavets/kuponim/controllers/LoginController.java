package com.derzhavets.kuponim.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.SystemService;

@RestController
public class LoginController {
	
	@Autowired
	private SystemService systemService;
	
	/**
	 * Login endpoint to perform user authorization
	 * 
	 * @param request containing user email, password and type to check credentials and perform
	 * login
	 * @return ResponseEntity with authenticated user details
	 * @throws UserNotFoundException in case of user credentials are invalid
	 */
	@GetMapping("/login")
	public ResponseEntity<KuponimUser> login(HttpServletRequest request) throws UserNotFoundException {
		return ResponseEntity.ok().body(systemService.login(request));			
	}
	
	/**
	 * Logout endpoint to perform logging out of the logged in user. That simple
	 * 
	 * @param request containing current user session details
	 * @return ReponseEntity with confirmation of successful logout 
	 */
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		return ResponseEntity.ok().body(systemService.logout(request));
	}
}
