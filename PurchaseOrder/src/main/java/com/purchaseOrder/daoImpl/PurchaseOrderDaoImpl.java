package com.purchaseOrder.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.PurchaseOrder;

@Transactional
@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public boolean addPurchaseOrder(PurchaseOrder pobj) {
		try {
			Session session=sessionFactory.getCurrentSession();
	
			session.persist(pobj);
			return true;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
