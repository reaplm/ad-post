package com.adpost.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;









import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
import com.adpost.domain.model.enumerated.MenuStatus;
import com.adpost.domain.model.enumerated.MenuType;
import com.adpost.service.IMenuService;

@Controller
public class MenuController {
	@Autowired
	private IMenuService iMenuService;
	

	@RequestMapping(value="/menus", method=GET)
	public ModelAndView getAllMenus(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		
		ModelAndView modelAndView = new ModelAndView("menus");
		//Get all the menus and submenus
		List<Menu> menuList = getMenuList();
		List<Menu> adminMenus = getMenusByType("ADMIN");
		session.setAttribute("adminMenus", adminMenus);
		modelAndView.addObject("title", "Activities");
		modelAndView.addObject("menuList", menuList);

		return modelAndView;
	}
	@RequestMapping(value="/menus/home",method=GET)
	@ResponseBody
	public ModelAndView getHomeMenus(
			@RequestParam(value="menuType") String menuType){
		//Get all the menus
		List<Menu> menuList = getMenuList(menuType.toUpperCase());
		ModelAndView model = new ModelAndView("homeMenus");
		model.addObject("menuList", menuList);
		return model;
	}
	@RequestMapping(value="/menus/submenus",method=GET)
	@ResponseBody
	public List<SubMenu> getSubMenus(
			@RequestParam(value="parentMenuId") int parentMenuId){
		//Get all the menus
		List<SubMenu> subMenuList = getSubMenuList(parentMenuId);

		return subMenuList;
	}
	@RequestMapping(value="/menus/type",method=GET)
	@ResponseBody
	public List<Menu> getMenusByType(
			@RequestParam(value="menuType") String menuType){
		//Get all the menus
		List<Menu> menuList = getMenuList(menuType.toUpperCase());
		return menuList;
	}
	@RequestMapping(value="/menu/detail",method=GET)
	@ResponseBody
	public Menu getMenuDetail(
			@RequestParam(value="id") int menuId){
		return iMenuService.getMenu(menuId);

	}
	@RequestMapping(value="/submenu/detail",method=GET)
	@ResponseBody
	public SubMenu getSubMenuDetail(
			@RequestParam(value="id") int subMenuId){
		return getSubMenuById(subMenuId);

	}
	@RequestMapping(value="/menu/status")
	@ResponseBody
	public List<Menu> getMenuListByStatus(
			@RequestParam(value="status") String menuStatus){
		return iMenuService.getMenusByStatus(menuStatus);
	}
	@RequestMapping(value="/menu/add", method=RequestMethod.POST)
	@ResponseBody
	public boolean createMenu(HttpServletRequest request, 
			HttpServletResponse response){
		
		int parentMenuId = -1;
		boolean success = false;

		try{
			if(request.getParameter("parentId") != null){
				parentMenuId = Integer.parseInt(request.getParameter("parentId"));

				String menuType = request.getParameter("menuType");
				Menu menu = null;
				SubMenu subMenu = null;
				String url = null;
				
				if(parentMenuId == 0){//not a sub menu
					url = "/AdPost/menu/detail";
					menu = createMenu(request.getParameter("title"),
							request.getParameter("description"), url,
							request.getParameter("icon"),menuType);
					iMenuService.insertMenu(menu);
				}else{
					url = "/AdPost/submenu/detail";
					menu = iMenuService.getMenu(parentMenuId);
					subMenu = createSubMenu(request.getParameter("title"),
							request.getParameter("description"), url,
							request.getParameter("icon"), 
							menuType);
					subMenu.setMenu(menu);
					iMenuService.insertSubMenu(subMenu);	
				}
				success = true;
			}
			else{
				success = false;
			}
		}
		catch(NumberFormatException exception){
			System.out.println("NumberFormatException in '/AdPost/menu/add'"
					+ " \nException message: " + exception);
		}
		return success;
	}
	@RequestMapping(value="/menu/edit", method=RequestMethod.POST)
	@ResponseBody
	public boolean updateMenu(HttpServletRequest request, 
			HttpServletResponse response){
		int menuId = 0;
		boolean success = false;
		String id = request.getParameter("menuId");
		String menuType = request.getParameter("menuType").toLowerCase();
		if(request.getParameter("menuId") != null){
			menuId = Integer.parseInt(request.getParameter("menuId"));
			if(menuType != null){
				switch(menuType){
				case "menu":
					Menu menu = iMenuService.getMenu(menuId);
					menu.setMenuDesc(request.getParameter("editDescription"));
					menu.setMenuName(request.getParameter("editTitle"));
					menu.setIcon(request.getParameter("editIcon"));
					menu.setUrl(request.getParameter("editUrl"));
					if(request.getParameter("status").compareToIgnoreCase("active") == 0)
						menu.setMenuStatus(MenuStatus.ACTIVE);
					else if(request.getParameter("status").compareToIgnoreCase("inactive") == 0)
						menu.setMenuStatus(MenuStatus.INACTIVE);
					
					iMenuService.updateMenu(menu);
					success = true;
					break;
				case "submenu":
					SubMenu subMenu = iMenuService.getSubMenuById(menuId);
					subMenu.setSubMenuDesc(request.getParameter("editDescription"));
					subMenu.setSubMenuName(request.getParameter("editTitle"));
					subMenu.setIcon(request.getParameter("editIcon"));
					subMenu.setUrl(request.getParameter("editUrl"));
					
					
					iMenuService.insertSubMenu(subMenu);
					success = true;
					break;
			}
		}
			
			
			
			
		}
		return success;

	}

	@RequestMapping(value="/menu/delete", method=GET)
	public void deleteMenu(HttpServletRequest request, 
			HttpServletResponse response,
		@ModelAttribute("menu") Menu menu){	
		iMenuService.deleteMenu(menu);
}
	@RequestMapping(value="/menu/all", method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenuAjax(HttpServletRequest request, 
			HttpServletResponse response) throws JSONException{
		
		response.setContentType("application/json");
		//List<Menu> menuList = iMenuService.getAllMenus();
		
		return getMenuList();
	}
	@RequestMapping(value="/status", method=RequestMethod.GET)
	@ResponseBody
	public List<MenuStatus> getStatus(){
		return new ArrayList<MenuStatus>(Arrays.asList(MenuStatus.values()));

	}

	private List<Menu> getMenuList(){
		return iMenuService.getAllMenus();
	}
	private List<Menu> getMenuList(String menuType){
		return iMenuService.getAllMenus(menuType);
	}
	private List<Menu> getMenusByStatus(String menuStatus){
		return iMenuService.getMenusByStatus(menuStatus);
	}
	private List<SubMenu> getSubMenuList(int parentMenuId){
		return iMenuService.getAllSubMenus(parentMenuId);
	}
	private SubMenu getSubMenuById(int id){
		return iMenuService.getSubMenuById(id);
	}
	private Menu createMenu(String title, String description, String url,
			String icon,String menuType){
		Menu menu = new Menu();
		menu.setMenuName(title);
		menu.setMenuDesc(description);
		menu.setUrl(url);
		menu.setIcon(icon);
		menu.setMenuStatus(MenuStatus.ACTIVE);
		
		switch(menuType){
			case "category":
				menu.setMenuType(MenuType.CATEGORY);
				break;
			case "sidebar":
				menu.setMenuType(MenuType.ADMIN);
				break;
			default:
				menu.setMenuType(MenuType.UNCLASSIFIED);
				break;	
		}
		return menu;
	}
	private SubMenu createSubMenu(String title, String description, String url,
			String icon,String menuType){
		SubMenu subMenu = new SubMenu();
		subMenu.setSubMenuName(title);
		subMenu.setSubMenuDesc(description);
		subMenu.setUrl(url);
		subMenu.setIcon(icon);
		subMenu.setMenuStatus(MenuStatus.ACTIVE);
		
		switch(menuType){
			case "category":
				subMenu.setMenuType(MenuType.CATEGORY);
				break;
			case "sidebar":
				subMenu.setMenuType(MenuType.ADMIN);
				break;
			default:
				subMenu.setMenuType(MenuType.UNCLASSIFIED);
				break;	
		}

		return subMenu;
	}
}
