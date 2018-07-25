package com.derzhavets.kuponim.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "CUSTOMERS")
public class Customer {
	
	@Id @GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private Long id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "CUSTOMER_COUPON", 
			joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
			inverseJoinColumns = @JoinColumn(name = "COUPON_ID"))
	private Set<Coupon> coupons = new HashSet<>();
	
	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
