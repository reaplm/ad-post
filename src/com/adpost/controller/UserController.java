package com.adpost.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AppUser;
import com.adpost.service.IUserService;

@Controller
public class UserController{
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="/admin/users", method=GET)
	public @ResponseBody ModelAndView getUsers(HttpServletRequest request,
			HttpServletResponse response){
		List<AppUser> userList = iUserService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("users");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	@RequestMapping(value="/admin/permissions", method=GET)
	public @ResponseBody ModelAndView getPermissions(HttpServletRequest request,
			HttpServletResponse response){
		List<AppUser> userList = iUserService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("permissions");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	/*@RequestMapping(value="/admin/user/detail", method=GET)
	public @ResponseBody ModelAndView getUserDetail(HttpServletRequest request,
			HttpServletResponse response){
		List<AppUser> userList = iUserService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("permissions");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}*/
	@RequestMapping(value="/admin/user/detail", method=RequestMethod.GET)
	public @ResponseBody AppUser userDetail(HttpServletRequest request, 
			HttpServletResponse response, @RequestParam("id") int id)
					throws NumberFormatException, IOException, JSONException, ServletException{
		AppUser user = iUserService.getUser(id);
		//String userType = user.getClass().getSimpleName().toLowerCase();
		
	
		System.out.println("getting user with id "+id);
		return user;
	}
}
