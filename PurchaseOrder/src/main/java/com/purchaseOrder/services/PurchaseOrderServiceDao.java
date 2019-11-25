package com.purchaseOrder.services;

import java.util.List;

import com.purchaseOrder.model.PurchaseOrder;

public interface PurchaseOrderServiceDao {
	public boolean addPurchaseOrder(PurchaseOrder pobj);
	public List<PurchaseOrder> viewAllPo();

}
