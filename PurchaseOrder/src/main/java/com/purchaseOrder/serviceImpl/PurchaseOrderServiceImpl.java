package com.purchaseOrder.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.PurchaseOrder;
import com.purchaseOrder.services.PurchaseOrderServiceDao;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderServiceDao {

	
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	
	@Transactional
	@Override
	public boolean addPurchaseOrder(PurchaseOrder pobj) {
	
	pobj.setStatus("sent to seller");
		return purchaseOrderDao.addPurchaseOrder(pobj);
	}

	@Override
	public List<PurchaseOrder> viewAllPo() {
		// TODO Auto-generated method stub
		return viewAllPo();
	}

}
