package com.purchaseOrder.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.model.Buyer;

@Repository("userDao")
@Transactional
public class BuyerDaoImpl implements BuyerDao {

	@Autowired
	SessionFactory sessionfactory;
	private static final Logger logger = Logger.getLogger(BuyerDaoImpl.class);

	@Override
	public boolean registerBuyer(Buyer uobj) {

		try {
			logger.info("i in my buyer daoImpl and method name is registerBuyer");
			Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(uobj);
			return true;

		} catch (Exception e) {
			logger.error("error in registerBuyer" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Buyer Validatelogin(Buyer uobj) {
		try {
			logger.info("i in my buyerDaoImpl and method name is Validatelogin");
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from com.purchaseOrder.model.Buyer where Email=:x and password=:y");
			query.setParameter("x", uobj.getEmail());
			query.setParameter("y", uobj.getPassword());
			List<Buyer> list = query.list();
			if (list == null) {
				session.close();

			} else {
				if (list.size() != 0) {

					return list.get(0);

				}
			}

		} catch (Exception e) {
			logger.error("error in Validatelogin" + e.getMessage());
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Buyer getSeller() {
		try {
			logger.info("Im in BuyerDaoImpl and method name is getSeller ");
			Session session = sessionfactory.getCurrentSession();
			Query query = session.createQuery("from com.purchaseOrder.model.Buyer where role='Seller'");

			List<Buyer> list = query.list();
			if (list == null) {
				session.close();

			} else {
				if (list.size() != 0) {

					return list.get(0);

				}
			}

		} catch (Exception e) {
			logger.error("error in getSeller()" + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
}
