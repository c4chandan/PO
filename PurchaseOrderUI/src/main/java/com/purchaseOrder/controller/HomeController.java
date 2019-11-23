package com.purchaseOrder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView registerUserDetail(@Valid @ModelAttribute("buyerObj") Buyer buyerObj, BindingResult result) {

		if (result.hasErrors()) {

			

			System.out.println(result.getAllErrors());

			ModelAndView mv = new ModelAndView("Registration");
			mv.addObject("error", "User has not registered ..... plzz try again");
			return mv;
		}
		ModelAndView mv = new ModelAndView("success");
		service.registerBuyer(buyerObj);
		mv.addObject("msg", "User has been registered succesfully. Now u can Login");

		return mv;

	}

	// calling login form
	@RequestMapping(value = "/getLoginForm", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("login", new Buyer());
		return mv;

	}

	@RequestMapping(value = "/Loginform", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Buyer login) {

		System.out.println(login);

		ModelAndView mv = null;

		Buyer bobj = service.Validatelogin(login);

		if (bobj != null) {

			if (bobj.getRole().equals("Buyer"))

			{
				mv = new ModelAndView("buyerSuccess");

			} else if (bobj.getRole().equals("Seller")) {

				mv = new ModelAndView("SellerSuccess");

			}

			else if (bobj.getRole().equals("Vendor")) {
				mv = new ModelAndView("VendorSuccess");

			}
		} else {
			mv = new ModelAndView("Login");
			mv.addObject("msg", "please enter the valid login Email and Password");

		}
		return mv;

	}

	@RequestMapping(value = "/getPurchaseOrder", method = RequestMethod.GET)
	public String PoForm()

	{
		return "PoForm";

	}
}
