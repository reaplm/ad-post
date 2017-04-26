package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.AdPicture;
import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.FileUpload;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
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
	
	private final String uploadDirectory = "C:\'Users\'pmolefe\'Documents\'Uploads";
	
	@RequestMapping(value="/adverts", method=GET)
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
	}
	@RequestMapping(value="/advert/newpost", method=GET)
	public ModelAndView newAdvert(@ModelAttribute("adDetails") AdvertDetail advertDetails){
		ModelAndView model = new ModelAndView("postAd");
		List<Menu> menuList = getMenuList();
		model.addObject("menuList", menuList);
		return model;
	}
	@RequestMapping(value="/advert/add", method=POST)
	public void insertAdverts(HttpServletRequest request,
			HttpServletResponse response, 
			@ModelAttribute("fileUpload") FileUpload fileUpload,
			@RequestParam CommonsMultipartFile file)
					throws NumberFormatException, IOException, IllegalStateException, 
					ServletException, FileUploadException{
		
		List<FileItem> fileItems = new ServletFileUpload
					(new DiskFileItemFactory()).parseRequest(request);
		AdPicture picture = new AdPicture();
		picture.setImageName(file.getName());
		
		if(fileUpload != null && file.getSize() > 0){
			file.transferTo(new File(uploadDirectory + fileUpload.getFileName()));
		}
		Advert advert = createAdvert(fileUpload.getAdSubject(), fileUpload.getAdBody(),
				fileUpload.getAdLocation(),fileUpload.getContactEmail(),
				fileUpload.getContactNo(), fileUpload.getSubMenuId(), picture);
		
		if(advert != null){
			iAdvertService.insertAdvert(advert);
		}
		response.sendRedirect("/AdPost/adverts"); 
	}
	@RequestMapping(value="/advert/detail", method=GET)
	public @ResponseBody Advert getAdvert(
			@RequestParam("id") int id){
		Advert advert = iAdvertService.getAdvert(id);
		return advert;
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
			String contactEmail, String contactNo, int subMenuId, AdPicture picture){
		Advert advert = new Advert();
		AdvertDetail advertDetail = new AdvertDetail();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if(auth.getPrincipal().equals("anonymousUser")){
			return null;
		}
		else{
			User user = (User) auth.getPrincipal();
			AppUser appUser = iUserService.getUser(user.getUsername());
			SubMenu subMenu = iMenuService.getSubMenu(subMenuId);
			List<AdPicture> adPictures = new ArrayList<AdPicture>();
			adPictures.add(picture);
			advertDetail.setAdSubject(adSubject);
			advertDetail.setAdBody(adBody);
			advertDetail.setAdLocation(adLocation);
			advertDetail.setContactEmail(contactEmail);
			advertDetail.setContactNo(contactNo);
			iAdvertService.insertAdvertDetail(advertDetail);
			advertDetail.setAdPictures(adPictures);
			advert.setSubmittedDate(new Date());
			advert.setAdvertDetail(advertDetail);
			advert.setAppUser(appUser);
			advert.setSubMenu(subMenu);
			return advert;
		}
	}
}
