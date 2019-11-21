package com.purchaseOrder.daoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.purchaseOrder.dao.LoginDao;
import com.purchaseOrder.model.Login;

public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addLogin(Login loginobj) {
		try {
			Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(loginobj);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public String Validatelogin(String Email, String password) {
		try {

			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery("from com.purchaseOrder.model.Login where Email=:email and password=:password");
			query.setParameter("email", Email);
			query.setParameter("password",password);
			List<Login>list=query.list();	
			if(list.size()!=0)
			{
				return list.get(0).getRole();
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		return null;
	}

}
