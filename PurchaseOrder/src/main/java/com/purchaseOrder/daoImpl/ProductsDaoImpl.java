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
	public List<Products> viewAllProducts() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.models.Products");
			List<Products> productList = q.list();
			return productList;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
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
                        Session session = sessionFactory.getCurrentSession();
                        session.update(productObj);
                        return true;
        } catch (Exception e) {
                        e.printStackTrace();

        }

        return false;
    }

    @Override
    public Products getProductByName(String productName) {
        try {
            Session session=sessionFactory.getCurrentSession();
            Products pro=session.get(Products.class,productName);
            return pro;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        return null;
    }



}
