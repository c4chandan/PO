package com.purchaseOrder.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue
	private int po_Id;
	
    private String po_name;
	
    private int products_id;
    
    private int buyer_id;

    private String status;
    
    private LocalDate created_date;

    private int quantity;

	public int getPo_Id() {
		return po_Id;
	}

	public void setPo_Id(int po_Id) {
		this.po_Id = po_Id;
	}

	public String getPo_name() {
		return po_name;
	}

	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProducts_id() {
		return products_id;
	}

	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}

	@Override
	public String toString() {
		return "PurcahseOrder [po_Id=" + po_Id + ", po_name=" + po_name + ", products_id=" + products_id + ", buyer_id="
				+ buyer_id + ", status=" + status + ", created_date=" + created_date + ", quantity=" + quantity + "]";
	}

	

    
		
}
    
    


