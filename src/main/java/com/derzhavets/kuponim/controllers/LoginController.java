package com.derzhavets.kuponim.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.services.SystemService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/")
	public ResponseEntity<String> login(HttpServletRequest request) {
		try {
			return ResponseEntity.ok().body(systemService.login(request));			
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
}
