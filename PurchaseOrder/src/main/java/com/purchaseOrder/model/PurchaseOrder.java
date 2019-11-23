package com.purchaseOrder.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue
	private int id;

	private int poId;
	private int buyerId;			//mapped with user table
	private int sellerId;         //from user table
	private int vendorId;           //from user table
	
	private int productId;      //from product table

	private int poQuantity;
	
	private LocalDate createdDate;
	private LocalDate deliveryDate;
	
	@OneToOne
	@JoinColumn(name="buyerId",insertable=false,updatable=false)
	Buyer buyerObj;

	@OneToOne
	@JoinColumn(name="productId",insertable=false,updatable=false)
	Products productObj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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

	public int getPoQuantity() {
		return poQuantity;
	}

	public void setPoQuantity(int poQuantity) {
		this.poQuantity = poQuantity;
	}

	public Buyer getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(Buyer buyerObj) {
		this.buyerObj = buyerObj;
	}

	public Products getProductObj() {
		return productObj;
	}

	public void setProductObj(Products productObj) {
		this.productObj = productObj;
	}

	
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", poId=" + poId + ", buyerId=" + buyerId + ", sellerId=" + sellerId
				+ ", vendorId=" + vendorId + ", productId=" + productId + ", poQuantity=" + poQuantity
				+ ", createdDate=" + createdDate + ", deliveryDate=" + deliveryDate + ", buyerObj=" + buyerObj
				+ ", productObj=" + productObj + "]";
	}

	
		
}
    
    


