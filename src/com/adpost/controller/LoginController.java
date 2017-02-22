package com.adpost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.adpost.service.IUserService;

@Controller
public class LoginController{
	@Autowired
	private IUserService iUserService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/login", method=GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	/**
	 * 
	 * @param loginError
	 * @return
	 */
	@RequestMapping(value="/login", params={"loginError"}, method=GET)
	public ModelAndView login(
			@RequestParam(value="loginError", required=false) String loginError){
		ModelAndView modelAndView = new ModelAndView("login");
		if(loginError != null){
			modelAndView.addObject("errorMsg", "Invalid email or password");
		}
		return modelAndView;
	}
	@RequestMapping(value="/logout", method = GET)
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("login");
	    model.addObject("Msg", "You have successfully logged out");
	    session.setAttribute("loggedIn", false);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return model;
	}
	@RequestMapping(value="/resetPassword", method=GET)
	public ModelAndView reset(){
		ModelAndView modelAndView = new ModelAndView("reset");
		return modelAndView;
	}
	@RequestMapping(value="/welcome", method=GET)
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMsg", "Hi! You have successfully logged into the application!");
		return model;
	}
	@RequestMapping(value="/accessDenied", method=GET)
	public ModelAndView accessDenied(){
		ModelAndView model = new ModelAndView("accessDenied");
		model.addObject("errorMsg", "YOU DO NOT HAVE PERMISSION TO "
				+ "ACCESS THIS RESOURCE. PLEASE ASK FOR ASSISTANCE");
		return model;
	}

}
