
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Menu;
import com.adpost.service.IMenuService;
import com.adpost.service.IUserService;

@Controller
public class AdPostController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IMenuService iMenuService;
	
	@RequestMapping(value="/contact", method=GET)
	public ModelAndView contact(){
		ModelAndView modelAndView = new ModelAndView("contact");
		modelAndView.addObject("title", "contact");
		return modelAndView;
	}
	@RequestMapping(value="/home", method=GET)
	public ModelAndView home(HttpServletResponse response,
			HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title", "home");
		List<Menu> menuList = iMenuService.getAllMenus("CATEGORY");
		modelAndView.addObject("categories", menuList);
		
		return modelAndView;
	}
	@RequestMapping(value="/about", method=GET)
	public ModelAndView about(){
		ModelAndView modelAndView = new ModelAndView("about");
		modelAndView.addObject("title", "about");
		return modelAndView;
	}
}
