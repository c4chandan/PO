package com.purchaseOrder.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.purchaseOrder.dao.LoginDao;
import com.purchaseOrder.model.Login;

public class LoginServiceImpl implements LoginDao {
		
	@Autowired
	LoginDao logindao;
	
	@Override
	public boolean addLogin(Login loginobj) {
	
		return  logindao.addLogin(loginobj);
		
		
	}

	@Override
	public String Validatelogin(String Email, String password) {
	return logindao.Validatelogin(Email, password);
		
	}

}
