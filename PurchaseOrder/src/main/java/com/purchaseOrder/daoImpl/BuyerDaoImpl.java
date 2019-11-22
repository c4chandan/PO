package com.purchaseOrder.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.model.Buyer;

@Repository("userDao")

public class BuyerDaoImpl implements BuyerDao {

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean registerBuyer(Buyer uobj) {
	
		try {
			Session session=sessionfactory.getCurrentSession();
	
			session.saveOrUpdate(uobj);
			return true;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Buyer Validatelogin(String Email, String password) {
		try {

			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery("from com.purchaseOrder.model.Buyer where Email=:email and password=:password");
			query.setParameter("email", Email);
			query.setParameter("password",password);
			List<Buyer>list=query.list();	
			if(list==null) {
				session.close();
		
		}
		else {
			if(list.size()!=0)
			{
				
				return list.get(0);
	
			}
		}
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	
}
}
