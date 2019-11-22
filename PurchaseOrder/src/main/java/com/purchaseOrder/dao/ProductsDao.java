package com.purchaseOrder.dao;

import java.util.List;

import com.purchaseOrder.model.Products;

public interface ProductsDao {
	

	public boolean addProduct(Products productObj);//use in quntity table by vendor
	public List<Products> viewAllProducts();
	public boolean deleteProduct(Products productObj);
	public boolean updateProduct(Products productObj);
public Products getProductById(int productId);
	public Products getProductByName(String name);
}
