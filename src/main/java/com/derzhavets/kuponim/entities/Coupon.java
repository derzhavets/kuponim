package com.derzhavets.kuponim.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.derzhavets.kuponim.helpers.CouponType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity @Table(name = "COUPONS")
public class Coupon {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUPON_ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "START_DATE")
	private LocalDate startDate;
	
	@Column(name = "END_DATE")
	private LocalDate endDate;
	
	@Column(name = "AMOUNT")
	private int amount;
	
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private CouponType type;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "PRICE", precision = 2)
	private double price;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
	@JsonBackReference
	private Company company;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;	
	}

	@Override
	public String toString() {
		return "Coupon [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount
				+ ", type=" + type + ", message=" + message + ", price=" + price + ", imageUrl=" + imageUrl
				+ ", company=" + company + "]";
	}
	
}
