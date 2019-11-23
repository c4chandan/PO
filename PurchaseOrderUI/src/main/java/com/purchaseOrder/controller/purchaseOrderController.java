package com.purchaseOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.model.PurchaseOrder;

@Controller
public class purchaseOrderController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	
	@RequestMapping(value="/purchaseOrder",method=RequestMethod.POST)
	public ModelAndView raisePurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder purchaseOrder,ModelMap map  ) {
		System.out.println("i m here");
		ModelAndView mv=new ModelAndView("SellerSuccess") ;
		System.out.println("i am going to finish");
		mv.addObject("msg","po is raised");
		return null;
		
		
	}
	

}
