package com.derzhavets.kuponim.login;

import com.derzhavets.kuponim.helpers.UserNotFoundException;

public interface Client {
	
	Client login(String name, String password) 
			throws UserNotFoundException;
	
}
