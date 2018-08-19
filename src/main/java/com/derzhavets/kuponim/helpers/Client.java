package com.derzhavets.kuponim.helpers;

import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

public interface Client {
	
	KuponimUser login(String name, String password) 
			throws UserNotFoundException;
	
}
