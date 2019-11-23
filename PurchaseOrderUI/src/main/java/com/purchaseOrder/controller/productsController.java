package com.purchaseOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.ProductsDao;

@Controller
public class productsController {

	@Autowired
	ProductsDao productdao;

	@RequestMapping(value = "/RaisePo", method = RequestMethod.GET)
	public String homeController(ModelMap map) {

		map.addAttribute("productDetails", productdao.viewAllProducts());
		return "raisePo";

	}

	@RequestMapping(value = "/viewAllProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView("ViewProducts");
		mv.addObject("productDetails", productdao.viewAllProducts());
		return mv;
	}

}
