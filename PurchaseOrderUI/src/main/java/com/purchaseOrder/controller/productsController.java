package com.purchaseOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.ProductsDao;
import com.purchaseOrder.model.Products;

@Controller
public class productsController {

	@Autowired
	ProductsDao productdao;

	
	@Autowired
	CheckSession check;
	//this is used to show all the data on the select option on jsp page
	@RequestMapping(value = "/RaisePo", method = RequestMethod.GET)
	public String homeController(ModelMap map) {
		boolean r=check.checkSession();
		if(r) {
		map.addAttribute("productDetails", productdao.viewAllProducts());
		return "raisePo";
		}
		else {
			return "redirect:/getLoginForm";
		}

	}

	
	@RequestMapping(value = "/viewAllProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		check.checkSession();
		ModelAndView mv = new ModelAndView("ViewProducts");
		mv.addObject("productDetails", productdao.viewAllProducts());
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductNameById",method=RequestMethod.GET)
	public Products getProductById(@RequestParam int productId) {
		check.checkSession();
		Products pObj=productdao.getProductById(productId);
		return pObj;
	}

}
