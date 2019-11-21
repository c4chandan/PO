package com.purchaseOrder.services;

import com.purchaseOrder.model.Login;

public interface LoginService {
	
	public boolean addLogin(Login loginobj);
	public String Validatelogin(String Email,String password);
}
