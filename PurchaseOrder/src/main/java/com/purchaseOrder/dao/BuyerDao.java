package com.purchaseOrder.dao;

import com.purchaseOrder.model.Buyer;

public interface BuyerDao {

	public boolean registerBuyer(Buyer uobj);

	public Buyer Validatelogin(Buyer uobj);
	public Buyer getSeller();
}
