package com.derzhavets.kuponim.login;

import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

public interface Client {
	
	Client login(String name, String password) 
			throws UserNotFoundException;
	
}
