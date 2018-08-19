package com.derzhavets.kuponim.entities;

public class KuponimUser {
	
	private final Long id;
	private final String name;
	private final String email;
	
	public KuponimUser(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	
}
