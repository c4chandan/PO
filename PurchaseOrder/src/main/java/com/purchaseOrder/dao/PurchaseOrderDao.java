package com.purchaseOrder.dao;

import java.util.List;

import com.purchaseOrder.model.Products;
import com.purchaseOrder.model.PurchaseOrder;
import com.purchaseOrder.model.PurchaseOrderItems;

public interface PurchaseOrderDao {
	
	public boolean addPurchaseOrder(PurchaseOrder pobj);
	public List<PurchaseOrder> viewAllPo();
	public PurchaseOrderItems getPoById(int poId);

}
