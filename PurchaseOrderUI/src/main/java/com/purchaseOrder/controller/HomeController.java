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


import com.purchaseOrder.model.Buyer;
import com.purchaseOrder.services.BuyerService;

@Controller
public class HomeController {
	@Autowired
	BuyerService service;

	// HomePage
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeController(ModelMap map) {

		map.addAttribute("msj", "Welcome to home page");

		return "HomePage";

	}

	// calling Registration Page
	@RequestMapping(value = "/getSignUpPage", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		map.addAttribute("buyerObj", new Buyer());

		return "Registration";
	}

	// successfully registered
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUserDetail(@ModelAttribute("buyerObj") Buyer buyerObj) {

		ModelAndView mv = new ModelAndView("success");

		service.registerBuyer(buyerObj);
		mv.addObject("msg", "User has been registered succesfully. Now u can Login");
		return mv;
	}

	// calling login form
	@RequestMapping(value = "/getLoginForm", method = RequestMethod.GET)
	public String signIn()

	{
		return "Login";

	}

	@Autowired
	HttpSession session;


	@RequestMapping(value = "/Loginform", method = RequestMethod.POST)
	public String SignInfrom(@RequestParam String Email, @RequestParam String password) {
		Buyer bobj = service.Validatelogin(Email, password);

		session.setAttribute("uobj1", bobj);
		if (bobj != null) {

			if (bobj.getRole().equals("Buyer"))

			{

				return "buyerSuccess";

			} else if (bobj.getRole().equals("Seller")) {

				return "SellerSuccess";
			}
		}

		return "VendorSuccess";

	}

	@RequestMapping(value = "/getPurchaseOrder", method = RequestMethod.GET)
	public String PoForm()

	{
		return "PoForm";

	}
}
