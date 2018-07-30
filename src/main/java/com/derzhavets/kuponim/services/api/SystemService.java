package com.derzhavets.kuponim.services.api;

import javax.servlet.http.HttpServletRequest;

import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.exceptions.SessionNotFoundException;

public interface SystemService {

	String login(HttpServletRequest request);

	Client getClient(HttpServletRequest request) throws SessionNotFoundException;

}