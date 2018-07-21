package com.derzhavets.kuponim.login;

import com.derzhavets.kuponim.helpers.ClientType;

public interface Client {
	
	Client login(String name, String password, ClientType clientType);
	
}
