package com.citi.dde.achweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citi.dde.achweb.pojo.LogInUserDetails;
import com.citi.dde.common.logger.DFPLogger;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showPage() {
		DFPLogger.logDebug(getClass(), "Entering in showPage() method");
		LogInUserDetails smUserDetails = new LogInUserDetails();
		DFPLogger.logDebug(getClass(), "Exiting from showPage() method");
		return new ModelAndView("login", "smUserDetails", smUserDetails);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showHome(@ModelAttribute LogInUserDetails userDetails, HttpServletRequest request) {
		
		String userRole = userDetails.getUserRole();
		if ("C".equalsIgnoreCase(userRole)) {
			userDetails.setCheckerRole(true);
		} else if ("M".equalsIgnoreCase(userRole)) {
			userDetails.setMakerRole(true);
		} else if ("D".equalsIgnoreCase(userRole)) {
			userDetails.setDualRole(true);
		} else if ("V".equalsIgnoreCase(userRole)) {
			userDetails.setViewRole(true);
		}
		userDetails.setUserName(userDetails.getUserName());
		
		request.getSession().setAttribute("userDetails", userDetails);
		return new ModelAndView("homepage");
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		DFPLogger.logDebug(getClass(), "Entering in logout() method");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		request.getSession().setAttribute("userDetails",null);
		DFPLogger.logDebug(getClass(), "Exiting from logout() method");
		return new ModelAndView("closewindow");
	}
}
