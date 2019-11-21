package com.purchaseOrder.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	

}
