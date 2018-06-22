package com.derzhavets.kuponim.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "COMPANIES")
public class Company {

	@Id @GeneratedValue
	@Column(name = "COMPANY_ID") 
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany
	@JoinTable(name = "COMPANY_COUPON", 
				joinColumns = @JoinColumn(name = "COMPANY_ID"),
				inverseJoinColumns = @JoinColumn(name = "COUPON_ID"))
	private Set<Coupon> coupons = new HashSet<>();
	
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
	public Collection<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", coupons="
				+ coupons + "]";
	}
	
	
	
}
