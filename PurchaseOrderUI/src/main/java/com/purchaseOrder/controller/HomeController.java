package com.purchaseOrder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.purchaseOrder.dao.BuyerDao;
import com.purchaseOrder.dao.LoginDao;
import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.model.Login;
import com.purchaseOrder.services.BuyerService;


@Controller
public class HomeController {
	@Autowired
	BuyerService service;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homeController(ModelMap map ) {
	
		map.addAttribute("msj", "Welcome to home page");

	return "HomePage";

	}
	@RequestMapping(value = "/getSignUpPage", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		map.addAttribute("buyerObj", new Buyer());
		
		return "Registration";
	}	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUserDetail(@ModelAttribute("buyerObj") Buyer buyerObj) {

		
			ModelAndView mv = new ModelAndView("success");

			
			service.registerBuyer(buyerObj);
			mv.addObject("msg", "User has been registered succesfully. Now u can Login");
			return mv;
		}

	

	@RequestMapping(value = "/getLoginForm", method = RequestMethod.GET)
	public String signIn()

	{
		return "Login";

	}

	@Autowired
	HttpSession session;
	@Autowired
	LoginDao logindao;

	@RequestMapping(value = "/Loginform", method = RequestMethod.POST)
	public String SignInfrom(@RequestParam String Email, @RequestParam String password) {
		Login obj =logindao.addLogin(Email,password);
		session.setAttribute("uobj1", obj);
		return "userLogin";
			}

	
	}

	

