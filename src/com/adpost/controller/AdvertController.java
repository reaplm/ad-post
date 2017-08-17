package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AdPicture;
import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.FileUpload;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
import com.adpost.exception.FailedToPersistObjectException;
import com.adpost.service.IAdvertService;
import com.adpost.service.IMenuService;
import com.adpost.service.IUserService;

@Controller
public class AdvertController {
	@Autowired
	private IAdvertService iAdvertService;
	@Autowired
	private IMenuService iMenuService;
	@Autowired
	private IUserService iUserService;
		
	/*@RequestMapping(value="/adverts", method=GET)
	public ModelAndView getAllAdverts(
			@ModelAttribute("advert") Advert advert,
			@ModelAttribute("adDetails") AdvertDetail advertDetails){
		ModelAndView modelAndView = new ModelAndView("adverts");
	
		List<Advert> advertList = getAdvertList();
		List<Menu> menuList = getMenuList();
		
		modelAndView.addObject("title", "Adverts");
		modelAndView.addObject("advertList", advertList);
		modelAndView.addObject("menuList", menuList);
		return modelAndView;
	}*/
	@RequestMapping(value="/admin/posts")
	public ModelAndView posts(){
		ModelAndView model = new ModelAndView("posts");
		List<Advert> posts = iAdvertService.getAllAdverts();
		model.addObject("advertList", posts);
		return model;
	}
	@RequestMapping(value="/advert/newpost", method=GET)
	public ModelAndView newAdvert(@ModelAttribute("adDetails") AdvertDetail advertDetails){
		ModelAndView model = new ModelAndView("postAd");
		List<Menu> menuList = getMenuList();
		model.addObject("menuList", menuList);
		return model;
	}
	@RequestMapping(value="/advert/add", method=POST)
	public void submitAdvert(HttpServletRequest request,
			HttpServletResponse response, 
			@ModelAttribute("fileUpload") FileUpload fileUpload)
				throws IOException, IllegalStateException, 
				ServletException, FailedToPersistObjectException{

		@SuppressWarnings("unused")
		List<String> fileNames = new ArrayList<String>();
		List<AdPicture> pictures =  new ArrayList<AdPicture>();
		boolean success = false;
		

		
		try{
			Advert advert = createAdvert(fileUpload.getAdSubject(), 
					fileUpload.getAdBody(),fileUpload.getAdLocation(),
					fileUpload.getContactEmail(), fileUpload.getContactNo(), 
					fileUpload.getSubMenuId());

			AdPicture image = new AdPicture();
			image.setGroupCdnUrl(fileUpload.getGroupCdnUrl());
			image.setGroupUuid(fileUpload.getGroupUuid());
			image.setGroupCount(fileUpload.getGroupCount());
			image.setGroupSize(fileUpload.getGroupSize());
			//set properties of the current image and persist
			 for(int i = 0; i < fileUpload.getUuid().size(); i++ ){
				 image.setUuid(fileUpload.getUuid().get(i));
				 image.setCdnUrl(fileUpload.getCdnUrl().get(i));
				 image.setName(fileUpload.getName().get(i));
				 image.setSize(fileUpload.getSize().get(i));
				//persist the parent first, set the parent in child then persist the child
				 image.setAdvertDetail(advert.getAdvertDetail());
				 pictures.add(image);
				 iAdvertService.insertAdPicture(image);
			 }
				
		advert.getAdvertDetail().setAdPictures(pictures);
		success = updateAdvert(advert);
		
		}catch(Exception e){
			System.out.println("an error occured in image.transferTo(imageFile): " + e);
			e.printStackTrace();
		}
		response.sendRedirect("/AdPost/adverts"); 
	}
	@RequestMapping(value="/adverts", method=GET)
	public @ResponseBody ModelAndView getAdvert(
			@RequestParam(value="id", required=false, defaultValue="-1") int id,
			@ModelAttribute("advert") Advert advert,
			@ModelAttribute("adDetails") AdvertDetail advertDetails){
		ModelAndView modelAndView = new ModelAndView();
		if(id < 0){
			modelAndView.setViewName("adverts");
			List<Advert> advertList = getAdvertList();
			List<Menu> menuList = getMenuList();
			modelAndView.addObject("title", "Adverts");
			modelAndView.addObject("advertList", advertList);
			modelAndView.addObject("menuList", menuList);
			return modelAndView;
		}else{
			modelAndView.setViewName("adDetail");
			advert = iAdvertService.getAdvert(id);
			List<AdPicture> imageList = iAdvertService.getAdDetailPictures
					(advert.getAdvertDetail().getAdDetailId());
			modelAndView.addObject("advert", advert);
			modelAndView.addObject("adPictures", imageList);
		}
		return modelAndView;
	}
	@RequestMapping(value="/admin/advert/detail", method=GET)
	public @ResponseBody ModelAndView getAdminAdvert(
			@RequestParam("id") int id){
		ModelAndView model = new ModelAndView("adminAdDetail");
		Advert advert = iAdvertService.getAdvert(id);
		List<AdPicture> imageList = iAdvertService.getAdDetailPictures
				(advert.getAdvertDetail().getAdDetailId());
		model.addObject("advert", advert);
		model.addObject("adPictures", imageList);
		return model;
	}
	
	
	@RequestMapping(value="/advert/post-ad", method=GET)
	public ModelAndView postAd(@ModelAttribute FileUpload fileUpload){
		ModelAndView model = new ModelAndView("postAd");
		List<Menu> menuList = getMenuList("category");
		model.addObject("menuList", menuList);
		model.addObject("fileUpload",new FileUpload());
		return model;
	}
	
	private List<Advert> getAdvertList(){
		return iAdvertService.getAllAdverts();
	}
	private List<Menu> getMenuList(){
		return iMenuService.getAllMenus();
	}
	private List<Menu> getMenuList(String menuType){
		return iMenuService.getAllMenus(menuType);
	}
	private Advert createAdvert(String adSubject, String adBody, String adLocation,
			String contactEmail, String contactNo, int subMenuId){
			
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if(auth.getPrincipal().equals("anonymousUser")){
			return null;
		}
		else{
			User user = (User) auth.getPrincipal();
			AppUser appUser = iUserService.getUser(user.getUsername());
			SubMenu subMenu = iMenuService.getSubMenu(subMenuId);
			AdvertDetail advertDetail = new AdvertDetail();
			Advert advert = new Advert();

			//persist the parent first
			advert.setSubmittedDate(new Date());
			advert.setAppUser(appUser);
			advert.setSubMenu(subMenu);
			advert.setAdvertDetail(advertDetail);
			advert = iAdvertService.getAdvert
					(iAdvertService.insertAdvert(advert));
			
			advertDetail.setAdSubject(adSubject);
			advertDetail.setAdBody(adBody);
			advertDetail.setAdLocation(adLocation);
			advertDetail.setContactEmail(contactEmail);
			advertDetail.setContactNo(contactNo);
			advertDetail.setAdvert(advert);
			//set parent in child and persist child
			iAdvertService.insertAdvertDetail(advertDetail);	
						
			return iAdvertService.getAdvert(advert.getAdvertId());
		}
		
	}
	private boolean insertAdvert(Advert advert){
		if(advert != null){
			int id = iAdvertService.insertAdvert(advert);
			return true;
		}
		else return false;
	}
	private boolean updateAdvert(Advert advert){
		if(advert != null){
			iAdvertService.updateAdvert(advert);
			return true;
		}
		else return false;
	}
	//https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
	private String openHTTPConnection(String upLoadUrl){
		HttpURLConnection httpConnection = null;
		BufferedReader br;
		String line;
		String result = null;
		
		try{
			URL url = new URL(upLoadUrl);
			httpConnection = (HttpURLConnection) url.openConnection();
			//Request headers
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/vnd.uploadcare-v0.5+json");
			httpConnection.setRequestProperty("Authorization",
					"Uploadcare.Simple 402840513ca8fdd44f3b:248a2cdd20ea47dae231");
			
			br = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			while((line = br.readLine()) != null)
				result += line;
			
			br.close();
		}
		catch(Exception e){
			System.out.println("Error in openHTTPConnection" + e);
			e.printStackTrace();
		}
		return result;
	}
	private void closeHTTPConnection(HttpURLConnection connection){
		connection.disconnect();
	}
}
