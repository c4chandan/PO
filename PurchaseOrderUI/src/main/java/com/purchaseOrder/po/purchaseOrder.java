package com.purchaseOrder.po;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.ProductsDao;
import com.purchaseOrder.model.Products;

@Controller
public class purchaseOrder {

	@Autowired
	ProductsDao productdao;

	//vendor-can add products
	@RequestMapping(value="/addProductForm",method=RequestMethod.GET)
	public ModelAndView getProductForm(){
		ModelAndView mv=new ModelAndView("AddProduct");
		mv.addObject("productObj",new Products());
		return mv;
	}
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("productObj")Products productObj){
		productdao.addProduct(productObj);
		
		ModelAndView mv=new ModelAndView("ViewProducts");
		mv.addObject("productDetails",productdao.viewAllProducts());
		return mv;
	}
	
	@RequestMapping(value = "/RaisePo", method = RequestMethod.GET)
	public String homeController(ModelMap map) {
		
		map.addAttribute("productDetails", productdao.viewAllProducts());
		return "raisePo";

	}
	
	@RequestMapping(value="/viewAllProducts",method=RequestMethod.GET)
	public ModelAndView getAllProducts(){
		ModelAndView mv=new ModelAndView("ViewProducts");
		mv.addObject("productDetails",productdao.viewAllProducts());
		return mv;
	}
	

	/*
	 * 
	 * @RequestMapping(value="/fetchAllProducts",method=RequestMethod.GET) public
	 * List<Products> fetchAllProducts(){ List<Products>
	 * productList=productdao.viewAllProducts(); return productList; }
	 * 
	 * 
	 * @RequestMapping(value="/fetchAllProducts/{pId}",method=RequestMethod.GET)
	 * public Products fetchAllProductsById(@PathVariable("pId")int productId){
	 * Products obj=productdao.getProductById(productId); return obj; }
	 */
	

	@RequestMapping(value="/addProductNew",method=RequestMethod.POST)
	public boolean addProductBy(@RequestBody Products proObj){
		boolean res=productdao.addProduct(proObj);
		return res;
	}

}
