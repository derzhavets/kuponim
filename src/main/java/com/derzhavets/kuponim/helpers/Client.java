package com.derzhavets.kuponim.helpers;

import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

public interface Client {
	
	/**
	 * Perform user authentication with provided credentials
	 * 
	 * @param name of the sought user
	 * @param password of the sought user
	 * @return KuponimUser entity with found user details
	 * @throws UserNotFoundException in the user with provided credentials was not found in the database
	 */
	KuponimUser login(String name, String password) 
			throws UserNotFoundException;
	
}
