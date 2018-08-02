package com.derzhavets.kuponim.services;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.entities.Income;
import com.derzhavets.kuponim.services.api.IncomeConnectorService;

@Service
public class IncomeConnectorServiceImpl implements IncomeConnectorService {
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.IncomeConnectorService#sendIncome(com.derzhavets.kuponim.entities.Income)
	 */
	@Override
	public void sendIncome(Income income) {
		
		try {
			URL url  = new URL("http://localhost:8088/incomes");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			configureConnection(connection);
			OutputStream out = connection.getOutputStream();
			out.write(income.toJson().getBytes("UTF-8"));
			out.close();
			
			System.err.println(connection.getResponseCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configureConnection(HttpURLConnection connection) throws ProtocolException {
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setDoOutput(true);
	}
}
