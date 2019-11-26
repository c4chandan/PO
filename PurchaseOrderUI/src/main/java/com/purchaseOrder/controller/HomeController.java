package com.purchaseOrder.controller;

import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.purchaseOrder.model.PurchaseOrder;
import com.purchaseOrder.services.BuyerService;
import com.purchaseOrder.services.PurchaseOrderServiceDao;

@Controller
public class HomeController {
	@Autowired
	BuyerService service;

	@Autowired
	CheckSession check;

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/getSignUpPage", method = RequestMethod.GET)
	public String registerUser(ModelMap map) {

		try {
			logger.info("In WelcomeController");
			map.addAttribute("buyerObj", new Buyer());
			return "Registration";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in registerUserController" + e.getMessage());
		}
		return null;
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

		try {
			ModelAndView mv = new ModelAndView("Login");
			mv.addObject("login", new Buyer());
			service.registerBuyer(buyerObj);
			mv.addObject("msg", "User has been registered succesfully. Now u can Login");
			return mv;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in registerUserDetailcontroller" + e.getMessage());
		}
		return null;

	}

	// calling login form
	@RequestMapping(value = "/getLoginForm", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("login", new Buyer());
		return mv;

	}

	@Autowired
	HttpSession session;

	@Autowired
	PurchaseOrderServiceDao poObj;

	@RequestMapping(value = "/Loginform", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Buyer login) {

		System.out.println(login);

		try {
			ModelAndView mv = null;

			Buyer bobj = service.Validatelogin(login);

			if (bobj != null) {
				session.setAttribute("userObj", bobj);
				if (bobj.getRole().equals("Buyer"))

				{

					mv = new ModelAndView("buyerSuccess");

				} else if (bobj.getRole().equals("Seller")) {

					/*List<PurchaseOrder> pObj = poObj.viewAllPo();
					mv.addObject("poObj", pObj);
					System.out.println("I am in login procerss and the value of pobj is " + pObj + " ");*/
					mv = new ModelAndView("SellerSuccess");

				}

				else if (bobj.getRole().equals("Vendor")) {
					System.out.println("i m here");
					mv = new ModelAndView("vendorSuccess");

				}
			} else {
				mv = new ModelAndView("Login");
				mv.addObject("msg", "please enter the valid login Email and Password");

			}
			return mv;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in loginPageController" + e.getMessage());
		}
		return null;

	}

	@Autowired
	HttpServletResponse response;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		session.removeAttribute("userObj");

		return "HomePage";

	}

}
