package com.purchaseOrder.dao;

import com.purchaseOrder.model.Buyer;

public interface BuyerDao {

	public boolean registerBuyer(Buyer uobj);

	public Buyer Validatelogin(String Email,String password);
}
