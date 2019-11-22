package com.purchaseOrder.services;

import com.purchaseOrder.model.Buyer;

public interface BuyerService {

	public boolean registerBuyer(Buyer uobj);
	public Buyer Validatelogin(String Email,String password);
}
