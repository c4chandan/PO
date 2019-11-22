package com.purchaseOrder.services;

import java.util.List;

import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.model.Products;

public interface BuyerService {

	public boolean registerBuyer(Buyer uobj);
	public Buyer Validatelogin(String Email,String password);
	public boolean addProduct(Products pObj);
	public boolean deleteProduct(Products pObj);
	public boolean updateProduct(Products pObj);
	public Products getProductById(int pId);
	public List<Products> getAllProducts();
}
