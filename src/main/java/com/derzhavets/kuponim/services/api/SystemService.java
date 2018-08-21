package com.derzhavets.kuponim.services.api;

import javax.servlet.http.HttpServletRequest;

import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.exceptions.SessionNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

public interface SystemService {
	
	/**
	 * Perform login to the system by checking provided user credentials
	 * 
	 * @param request containing user credentials and client type
	 * @return KuponimUser entity with user details
	 * @throws UserNotFoundException in case use with provided credentials was not found
	 */
	KuponimUser login(HttpServletRequest request) throws UserNotFoundException;
	
	/**
	 * Perform check if the user session is registered in the system and is still valid
	 * 
	 * @param request containing current user session to check its validity
	 * @return client service according to requested client type
	 * @throws SessionNotFoundException in case user session was not found or is invalid
	 */
	Client getClient(HttpServletRequest request) throws SessionNotFoundException;
	
	/**
	 * Perform logout by invalidating current user session
	 * 
	 * @param request containing current user session to invalidate
	 * @return success if logout was successful
	 */
	String logout(HttpServletRequest request);

}