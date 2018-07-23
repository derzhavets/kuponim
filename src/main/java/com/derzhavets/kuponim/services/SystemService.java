package com.derzhavets.kuponim.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.ExpiringSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.SessionNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class SystemService {
	
	private final Map<ClientType, Client> clients = new HashMap<>();
	
	private final SessionRepository<ExpiringSession> sessionRepository = 
			new MapSessionRepository();
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	public Session login(String name, String password, ClientType clientType) 
			throws UserNotFoundException {
		Client client = clients.get(clientType).login(name, password);
		Session newSession = createSession(client);
		return newSession;
	}
	
	
	public Client getClient(String sessionId) throws SessionNotFoundException {
		ExpiringSession session = sessionRepository.getSession(sessionId);
		if (session == null)
			throw new SessionNotFoundException(
					"Session is expired or session token is corrupted. Please login again.");
		return session.getAttribute("client");
	}
	
	private Session createSession(Client client) {
		ExpiringSession session = sessionRepository.createSession();
		session.setAttribute("client", client);
		sessionRepository.save(session);
		return session;
		
	}
	
	@PostConstruct
	private void collectServices() {
		clients.put(ClientType.ADMIN, adminService);
		clients.put(ClientType.COMPANY, companyService);
		clients.put(ClientType.CUSTOMER, customerService);
	}
	
}
