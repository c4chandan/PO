package com.purchaseOrder.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.AddProductByVendorDao;
import com.purchaseOrder.dao.ProductsDao;
import com.purchaseOrder.model.AddProductByVendor;
import com.purchaseOrder.model.Buyer;

@Controller 
public class AddProductByVendorController {
	
	@Autowired
	AddProductByVendorDao vendorDaoObj;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ProductsDao productDao;
	
	@Autowired
	CheckSession check;
	
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {
		check.checkSession();
		map.addAttribute("pObjDetails", productDao.viewAllProducts());  
		
		//call to method to view all products
		return "viewAvailableProduct";    //jsp page showing all products detail

	}

	
		@RequestMapping(value="/updateQuantity",method=RequestMethod.GET)
		public String updateQuantity(ModelMap map) {
			
			check.checkSession();
			map.addAttribute("pObjDetails", productDao.viewAllProducts());  
			return "updateQuantity";    
		}

		@RequestMapping(value="/updateQuantity",method=RequestMethod.POST)
		public ModelAndView addInVendorproductTable(@RequestParam int pId  ,@RequestParam int quantity)
		{
			
			check.checkSession();
			Buyer buyerObj=(Buyer)session.getAttribute("userObj");		
			
			System.out.println("buyerObj : "+buyerObj);
			
			AddProductByVendor addpId=vendorDaoObj.checkingProductbyVendor(buyerObj.getBuyer_Id(), pId);  
			if(addpId!=null) {
				addpId.setQuantity(addpId.getQuantity()+quantity);  
			}
			else {
				addpId = new AddProductByVendor();		
				addpId.setVendorId(buyerObj.getBuyer_Id());
				addpId.setProductId(pId);
				addpId.setQuantity(quantity);
			}
			vendorDaoObj.addProduct(addpId); 
			ModelAndView mv=new ModelAndView("vendorSuccessPage");
			mv.addObject("msg","Product Quantity Added Succesfully");
			return mv;

}
		
		@RequestMapping(value="getAllProductsByVendor",method=RequestMethod.GET)
			public String getAllAvailableProductsOfVendor(ModelMap map) {
			
				check.checkSession();
				Buyer buyerObj=(Buyer)session.getAttribute("userObj");
				
				int vendorId=buyerObj.getBuyer_Id();
				
				map.addAttribute("pObjDetails",vendorDaoObj.getAllProducts(vendorId));
						
				return "availableProductsByVendor";
				

}
}