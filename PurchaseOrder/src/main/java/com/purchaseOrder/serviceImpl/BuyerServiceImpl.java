package com.purchaseOrder.serviceImpl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.services.BuyerService;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerDao buyerdao;
	
	@Override
	public boolean registerBuyer(Buyer uobj) {
		uobj.setIsActive("Y");
		uobj.setCreated_date(LocalDate.now());
		uobj.setCreated_by("System");

		return buyerdao.registerBuyer(uobj);
		
	}

}
