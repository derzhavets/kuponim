package com.derzhavets.kuponim.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.SessionNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class SystemService {
	
	private final Map<ClientType, Client> clients = new HashMap<>();
	
	private final Map<String, HttpSession> sessionsMap = new HashMap<>();
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	public String login(HttpServletRequest request) throws UserNotFoundException {
		ClientType type = ClientType.valueOf(request.getParameter("client-type"));
		clients.get(type).login(
				request.getParameter("email"), request.getParameter("password"));
		if (request.getSession() != null) 
			request.getSession().invalidate();
		HttpSession session = request.getSession();
		session.setAttribute("client-type", ClientType.ADMIN);
		sessionsMap.put(session.getId(), session); 
		return session.getId();
	}
	
	public Client getClient(HttpServletRequest request) throws SessionNotFoundException {
		HttpSession session = request.getSession(false);
		if (session == null || sessionsMap.get(session.getId()) == null) 
			throw new SessionNotFoundException(
					"Session is expired or session token is invalid. Please login again.");
		ClientType type = (ClientType) session.getAttribute("client-type");
		return clients.get(type);
	}
	
	@PostConstruct
	private void collectServices() {
		clients.put(ClientType.ADMIN, adminService);
		clients.put(ClientType.COMPANY, companyService);
		clients.put(ClientType.CUSTOMER, customerService);
	}
	
}
