package com.purchaseOrder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="addProductby_vendor")
public class AddProductByVendor {

	@Id
	@GeneratedValue
	private int id;
	private int vendorId;
	private int productId;
	private int quantity;

	@OneToOne
	@JoinColumn(name="productId",insertable=false,updatable=false)
	private Products product_Obj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
		
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public Products getProduct_Obj() {
		return product_Obj;
	}

	public void setProduct_Obj(Products product_Obj) {
		this.product_Obj = product_Obj;
	}

	@Override
	public String toString() {
		return "AddProductByVendor [id=" + id + ", vendorId=" + vendorId + ", productId=" + productId + ", quantity="
				+ quantity + ", product_Obj=" + product_Obj + "]";
	}

	 	
}
