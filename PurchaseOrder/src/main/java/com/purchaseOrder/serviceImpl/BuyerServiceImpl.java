package com.purchaseOrder.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.model.Products;
import com.purchaseOrder.services.BuyerService;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerDao buyerdao;
	
	@Override
	public boolean registerBuyer(Buyer uobj) {
		uobj.setRole("Buyer");
		uobj.setIsActive("Y");
		uobj.setCreated_date(LocalDate.now());
		uobj.setCreated_by("System");

		return buyerdao.registerBuyer(uobj);
		
	}

	@Override
	public Buyer Validatelogin(Buyer uobj) {
		
		
		return  buyerdao.Validatelogin(uobj);
	}

	@Override
	public boolean addProduct(Products pObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Products pObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Products pObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Products getProductById(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
