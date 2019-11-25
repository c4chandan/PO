package com.purchaseOrder.dao;

import java.util.List;

import com.purchaseOrder.model.AddProductByVendor;
import com.purchaseOrder.model.Products;

public interface AddProductByVendorDao {

	public boolean addProduct(AddProductByVendor vObj);

	public Products getProductById(int pObjId);

	public List<Products> getAllProducts(int pObjId);

	public AddProductByVendor checkingProductbyVendor(int vendorId, int productId);

}
