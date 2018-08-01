package com.derzhavets.kuponim.entities;

import java.time.LocalDateTime;

import com.derzhavets.kuponim.helpers.IncomeType;

public class Income {
	
	private Long id;
	private String client;
	private IncomeType description;
	private LocalDateTime date;
	private Double amount;
	
	public Income(String client, IncomeType incomeType, Double amount) {
		this.client = client;
		this.description = incomeType;
		this.amount = amount;
		this.date = LocalDateTime.now();
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public IncomeType getDescription() {
		return description;
	}

	public void setDescription(IncomeType description) {
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String toJson() {
		return String.format("{\"client\":\"%s\","
							+ "\"description\":\"%s\","
							+ "\"date\":\"%s\","
							+ "\"amount\":\"%.2f\"}", 
							client, description, date, amount);
		
	}
	
}
