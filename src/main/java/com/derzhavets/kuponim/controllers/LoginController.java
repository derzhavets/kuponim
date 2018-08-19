package com.derzhavets.kuponim.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.SystemService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/")
	public ResponseEntity<KuponimUser> login(HttpServletRequest request) throws UserNotFoundException {
		return ResponseEntity.ok().body(systemService.login(request));			
	}
}
