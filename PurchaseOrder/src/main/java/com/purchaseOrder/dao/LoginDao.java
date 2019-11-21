package com.purchaseOrder.dao;

import com.purchaseOrder.model.Login;

public interface LoginDao {
	public boolean addLogin(Login loginobj);
	public String Validatelogin(String Email,String password);
	
}
