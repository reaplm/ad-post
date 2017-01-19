package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
import com.adpost.domain.model.enumerated.MenuStatus;
import com.adpost.domain.model.enumerated.MenuType;
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
	
	private final String uploadDirectory = "C:\'AdPost\'Uploads";
	
	@RequestMapping(value="/adverts", method=GET)
	public ModelAndView getAllAdverts(
			@ModelAttribute("advert") Advert advert){
		ModelAndView modelAndView = new ModelAndView("adverts");
	
		List<Advert> advertList = getAdvertList();
		List<Menu> menuList = getMenuList();
		
		modelAndView.addObject("title", "Adverts");
		modelAndView.addObject("advertList", advertList);
		modelAndView.addObject("menuList", menuList);
		return modelAndView;
	}
	@RequestMapping(value="/advert/add", method=POST)
	public void insertAdverts(HttpServletRequest request,
			HttpServletResponse response)throws NumberFormatException, IOException{
		ModelAndView modelAndView = new ModelAndView("adverts");
		int subMenuId = Integer.parseInt(request.getParameter("subMenuId"));
		Advert advert = createAdvert(request.getParameter("adSubject"), 
				request.getParameter("adBody"), request.getParameter("adLocation"),
				request.getParameter("contactEmail"),request.getParameter("contactNo"),
				subMenuId);
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
	@RequestMapping(value="/picture/upload", method=POST)
	public @ResponseBody String uploadAdPicture(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String message = "";
		//process only if it's multipart content
		if(isMultipart){
			//create factory for disk based file items
			FileItemFactory factory = new DiskFileItemFactory();
			//create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				List<FileItem> multiparts = upload.parseRequest(request);
				for(FileItem fileItem:multiparts){
					if(!fileItem.isFormField()){
						String fileName = new File(fileItem.getName()).getName();
						fileItem.write(new File(uploadDirectory + 
								File.separator + fileName));
					}
				}
				message = "successfully uploaded";
			}
			catch(Exception e){
				System.out.println("Exception in /picture/upload: \n" + e);
				message = "Exception in /picture/upload: \n" + e;
			}
		}
		return message;
	}
	private List<Advert> getAdvertList(){
		return iAdvertService.getAllAdverts();
	}
	private List<Menu> getMenuList(){
		return iMenuService.getAllMenus();
	}
	private Advert createAdvert(String adSubject, String adBody, String adLocation,
			String contactEmail, String contactNo, int subMenuId){
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
			advertDetail.setAdSubject(adSubject);
			advertDetail.setAdBody(adBody);
			advertDetail.setAdLocation(adLocation);
			advertDetail.setContactEmail(contactEmail);
			advertDetail.setContactNo(contactNo);
			advert.setSubmittedDate(new Date());
			advert.setAdvertDetail(advertDetail);
			advert.setAppUser(appUser);
			advert.setSubMenu(subMenu);
			return advert;
		}
	}
}
