package com.purchaseOrder.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.PurchaseOrder;

@Transactional
@Repository("purchaseOrderDao")
public class PurchaseOrderImpl implements PurchaseOrderDao {

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


	@Override
	public List<PurchaseOrder> viewAllPo() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.purchaseOrder.model.PurchaseOrder where status='sent to seller'");
	        return q.list();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
