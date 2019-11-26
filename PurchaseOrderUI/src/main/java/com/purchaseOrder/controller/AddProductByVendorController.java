package com.purchaseOrder.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
		boolean r=check.checkSession();
		if(r) {
		map.addAttribute("pObjDetails", productDao.viewAllProducts());  
		
		//call to method to view all products
		
		return "viewAvailableProduct";   
		}
		else {
			return "redirect:/getLoginForm";
			
	}
		
	}
	
		@RequestMapping(value="/updateQuantity",method=RequestMethod.GET)
		public String updateQuantity(ModelMap map) {
			boolean r=check.checkSession();
			if(r) {
			map.addAttribute("pObjDetails", productDao.viewAllProducts());  
			return "updateQuantity";    
		}
			else
			{
				return  "redirect:/getLoginForm";
			}
		}

		@RequestMapping(value="/updateQuantity",method=RequestMethod.POST)
		public ModelAndView addInVendorproductTable(@Valid @RequestParam int pId  ,@RequestParam int quantity,BindingResult result)
		{
			
			if(result.hasErrors())
			{

				ModelAndView mv = new ModelAndView("updateQuantity");
				mv.addObject("error", "quantity not updated");
				return mv;
			}
			else {
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
			ModelAndView mv=new ModelAndView("updateQuantity");
			mv.addObject("msg","Product Quantity Added Succesfully");
			return mv;

}
		}
		@RequestMapping(value="getAllProductsByVendor",method=RequestMethod.GET)
			public String getAllAvailableProductsOfVendor(ModelMap map) {
			
			boolean r=check.checkSession();
			if(r) {
				Buyer buyerObj=(Buyer)session.getAttribute("userObj");
				
				int vendorId=buyerObj.getBuyer_Id();
				
				map.addAttribute("pObjDetails",vendorDaoObj.getAllProducts(vendorId));
						
				return "availableProductsByVendor";
			}
				else
				{
					return  "redirect:/getLoginForm";
				}
			}
				


}