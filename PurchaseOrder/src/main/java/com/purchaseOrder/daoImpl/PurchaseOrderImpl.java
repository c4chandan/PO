package com.purchaseOrder.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.Products;
import com.purchaseOrder.model.PurchaseOrder;
import com.purchaseOrder.model.PurchaseOrderItems;

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
			Query query=session.createQuery("from com.purchaseOrder.model.PurchaseOrder where status='Sent to Seller'");
			return query.list();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return null;
	}




	@Override
	public PurchaseOrderItems getPoById(int poId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			PurchaseOrderItems pro=session.get (PurchaseOrderItems.class,poId);
			return pro;
			}
			catch(Exception e){
				e.printStackTrace(); 
			}
			return null;
		
	}



}
