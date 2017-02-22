package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Role;
import com.adpost.domain.model.UserDetail;
import com.adpost.domain.model.enumerated.UserRole;
import com.adpost.domain.model.enumerated.UserStatus;
import com.adpost.service.IUserService;


@Controller
public class RegistrationController {

	@Autowired
	private IUserService iUserService;

	
	/**
	 * User registration page
	 * @return 
	 */
	@RequestMapping(value="/register", method=GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("title", "Ad Post Registration");
		return modelAndView;
	}
	/**
	 * Process user registration
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	@RequestMapping(value="/register", method=POST)
	public ModelAndView submitRegistration(HttpServletRequest request,
			HttpServletResponse response) 
					   throws ServletException, 
			IOException, NumberFormatException{
		
		AppUser appUser = new AppUser();
		ModelAndView modelAndView = null;
		ArrayList<String> errMsgs = new ArrayList<String>();
		Boolean error = false;
		Role role = new Role();
		ArrayList<Role> roles = new ArrayList<Role>();
		Date now = new Date((System.currentTimeMillis()));

		if(!iUserService.isValidEmail((request.getParameter("email")))){
			error = true;
			errMsgs.add("Email is already in use.");
		}
		if(error){
			modelAndView = new ModelAndView("register");
			modelAndView.addObject("errorMsg", errMsgs);
		}
		else{
			modelAndView = new ModelAndView("login");
			UserDetail userDetail = new UserDetail();
			userDetail.setFirstName(request.getParameter("firstName"));
			userDetail.setLastName(request.getParameter("lastName"));
			
			appUser.setUserDetail(userDetail);
			appUser.setCreateDate(now);
			appUser.setPasswordUsed(1);
			appUser.setUserStatus(UserStatus.INACTIVE);
			appUser.setEmail(request.getParameter("email"));
			appUser.setPassword(request.getParameter("password"));
			
			role.setRoleName(UserRole.ROLE_USER.getName());
			roles.add(role);
			appUser.setRole(roles);
			
			iUserService.createUser(appUser);
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("errorMsg", "Registration Successful. Please login");
			System.out.println("Registration Successful!");
		}
		return modelAndView;
	}
}
