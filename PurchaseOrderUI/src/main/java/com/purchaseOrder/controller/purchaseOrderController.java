package com.purchaseOrder.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.dao.ProductsDao;
import com.purchaseOrder.dao.PurchaseOrderDao;
import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.model.PurchaseOrder;
import com.purchaseOrder.model.PurchaseOrderItems;
import com.purchaseOrder.model.PurchaseOrder;

@Controller
public class purchaseOrderController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	/*
	@RequestMapping(value="/purchaseOrder",method=RequestMethod.POST)
	public ModelAndView raisePurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder purchaseOrder,ModelMap map  ) {
		System.out.println("i m here");
		ModelAndView mv=new ModelAndView("SellerSuccess") ;
		System.out.println("i am going to finish");
		mv.addObject("msg","po is raised");
		return null;
		
		
	}*/
	
	@Autowired
	HttpSession session;
	
	@Autowired
	BuyerDao buyerDao;
	
	@Autowired
	ProductsDao productDao;
	
	@RequestMapping(value="/raisePO",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<PurchaseOrderItems> purchaseOrderItemsList,ModelMap map) {
		Buyer bObj=(Buyer)session.getAttribute("userObj");
		
		PurchaseOrder po=new PurchaseOrder();
		po.setBuyerObj(bObj);
		po.setSellerObj(buyerDao.getSeller());


		
		for(PurchaseOrderItems obj:purchaseOrderItemsList) {
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(po);
		}
		
		po.setPurchaseOrderItemsObj(purchaseOrderItemsList);
		
				
		System.out.println("Purchase Order : "+po);
		
		
		purchaseOrderDao.addPurchaseOrder(po);
		
		map.addAttribute("msg","Purchase Order has been raised succesfully...");
		return "success";
		
		
	}

}
