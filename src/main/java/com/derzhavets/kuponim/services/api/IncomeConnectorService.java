package com.derzhavets.kuponim.services.api;

import com.derzhavets.kuponim.entities.Income;

public interface IncomeConnectorService {
	
	/**
	 * Establish connection with income registering microservice and post provided income entity
	 * containing all the details about business transaction and it's owner
	 * 
	 * @param income entity to be sent
	 */
	void sendIncome(Income income);

}