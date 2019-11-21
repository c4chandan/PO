package com.purchaseOrder.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.UserDao;
import com.purchaseOrder.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean registerUser(User uobj) {
	
		try {
			Session session=sessionfactory.getCurrentSession();
			
			session.save(uobj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
