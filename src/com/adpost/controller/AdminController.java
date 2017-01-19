package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AppUser;
import com.adpost.service.IUserService;

@Controller
public class AdminController {
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="/admin", method=GET)
	public ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("title", "Admin Home");
		return modelAndView;
	}
}
