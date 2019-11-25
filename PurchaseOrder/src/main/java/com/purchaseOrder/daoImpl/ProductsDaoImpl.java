package com.purchaseOrder.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.ProductsDao;
import com.purchaseOrder.model.Products;

@Repository("productsDao")
@Transactional
public class ProductsDaoImpl implements ProductsDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Products productObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				
				session.saveOrUpdate(productObj);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}


	
    @Override
    public boolean deleteProduct(Products productObj) {
                    try {
                                    Session session = sessionFactory.getCurrentSession();
                                    session.delete(productObj);
                                    return true;
                    } catch (Exception e) {
                                    e.printStackTrace();

                    }

                    return false;
    }

	@Override
	public boolean updateProduct(Products productObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(productObj);
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public Products getProductById(int productId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Products pro=session.get (Products.class,productId);
			return pro;
			}
			catch(Exception e){
				e.printStackTrace(); 
			}
			return null;
	}

	@Override
	public List<Products> viewAllProducts() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.purchaseOrder.model.Products");
			return query.list();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public Products getProductByName(String productName) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.purchaseOrder.model.Products where productName=:x");
			query.setParameter("x",productName);
			List prodList= query.list();
			if(prodList.size()!=0){
				return (Products)prodList.get(0);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}




}
