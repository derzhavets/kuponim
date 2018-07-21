package com.derzhavets.kuponim.login;

import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.UserNotFoundException;

public interface Client {
	
	Client login(String name, String password, ClientType clientType) 
			throws UserNotFoundException;
	
}
