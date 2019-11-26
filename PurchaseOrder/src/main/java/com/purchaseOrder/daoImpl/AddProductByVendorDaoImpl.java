package com.purchaseOrder.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.purchaseOrder.dao.AddProductByVendorDao;
import com.purchaseOrder.model.AddProductByVendor;
import com.purchaseOrder.model.Products;

@Repository("addProductByVendorDao")
@Transactional
public class AddProductByVendorDaoImpl implements AddProductByVendorDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addProduct(AddProductByVendor vObj) {
		try {
			Session session = sessionfactory.getCurrentSession();
			session.save(vObj); // we storing the products in our database
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Products getProductById(int pObjId) {
		try {

			Session session = sessionfactory.getCurrentSession();
			Products pObj = session.get(Products.class, pObjId); // we will fetch products on the basis of its id here
			return pObj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Products> getAllProducts(int pObjId) {

		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from com.purchaseOrder.model.AddProductByVendor where vendorId=:x");
			query.setParameter("x", pObjId); //here we will fetch all the products available to vendor 
			return query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AddProductByVendor checkingProductbyVendor(int vendorId, int productId) {

		try {
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from com.purchaseorder.model.AddProductByVendor where vendorId=:a and productId=:b");
			query.setParameter("a", vendorId);
			query.setParameter("b", productId); //calling vendorId and productId to check the productlist
			List list = query.list();
			if (list.size() != 0) {
				return (AddProductByVendor)list.get(0);
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

}
