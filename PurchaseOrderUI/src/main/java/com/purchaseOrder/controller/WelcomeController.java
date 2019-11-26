package com.purchaseOrder.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getWelcome() {
		try {
			logger.info("In WelcomeController");
			ModelAndView model = new ModelAndView("HomePage");
			model.addObject("msg", "Hello project i m logger");
			return model;
				
		} catch (Exception e) {
			logger.error("This is Error message "+e.getMessage());
			
		}
		return null;
		
	}
	

}
