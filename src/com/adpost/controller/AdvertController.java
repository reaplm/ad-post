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

import javax.annotation.Resource;
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
import com.adpost.exception.FailedToPersistObjectException;
import com.adpost.service.IAdvertService;
import com.adpost.service.IMenuService;
import com.adpost.service.IUserService;
import com.sun.xml.internal.ws.api.ResourceLoader;

@Controller
public class AdvertController {
	@Autowired
	private IAdvertService iAdvertService;
	@Autowired
	private IMenuService iMenuService;
	@Autowired
	private IUserService iUserService;
	
	private final String uploadDirectory = "C:/Users/pmolefe/Documents/AdPost/images/uploads";
	
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
	public void submitAdvert(HttpServletRequest request,
			HttpServletResponse response, 
			@ModelAttribute("fileUpload") FileUpload fileUpload)
					throws NumberFormatException, IOException, IllegalStateException, 
					ServletException, FileUploadException, FailedToPersistObjectException{
		
		//Get uploaded files and store them
		List<MultipartFile> files = fileUpload.getFiles();
		List<String> fileNames = new ArrayList<String>();
		List<AdPicture> pictures =  new ArrayList<AdPicture>();
		boolean success = false;
		
		try{
			Advert advert = createAdvert(fileUpload.getAdSubject(), fileUpload.getAdBody(),
					fileUpload.getAdLocation(),fileUpload.getContactEmail(),
					fileUpload.getContactNo(), fileUpload.getSubMenuId());
			if(files != null && files.size() > 0){
				for(MultipartFile image:files){
					AdPicture adPicture = new AdPicture();
					String fileName = image.getOriginalFilename();
					adPicture.setImageName(fileName);
					adPicture.setAdvertDetail(advert.getAdvertDetail());
					//persist the paprent first, set the parent in child then persist the child
					iAdvertService.insertAdPicture(adPicture);
					pictures.add(adPicture);
					//advert.getAdvertDetail().getAdPictures().add(adPicture);
					String[] fileSplit = fileName.split("\\.");
					fileNames.add(fileName);
					//File imageFile = new File(request.getServletContext().getRealPath("C:/Users/pmolefe/Documents/AdPost/images/uploads"), fileName);
					//File tempFile = File.createTempFile(fileSplit[0], "." + fileSplit[1],
							//new File(uploadDirectory));
					File directory = new File(uploadDirectory);
					if(!directory.exists()){
						directory.mkdirs();
					}
					//iAdvertService.updateAdvertDetail(advert.getAdvertDetail());
					File uploadedFile = new File(uploadDirectory+"\\"+Math.random()+fileName);
					uploadedFile.createNewFile();
					image.transferTo(uploadedFile);
				}
			}
		advert.getAdvertDetail().setAdPictures(pictures);
			success = insertAdvert(advert);
		
		
		}catch(Exception e){
			System.out.println("an error occured in image.transferTo(imageFile): " + e);
			e.printStackTrace();
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
}
