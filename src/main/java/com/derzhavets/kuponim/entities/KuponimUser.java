package com.derzhavets.kuponim.entities;

import com.derzhavets.kuponim.helpers.ClientType;

public class KuponimUser {
	
	private final Long id;
	private final String name;
	private final String email;
	private final ClientType type;
	
	public KuponimUser(Long id, String name, String email, ClientType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public ClientType getType() {
		return type;
	}
	
}
