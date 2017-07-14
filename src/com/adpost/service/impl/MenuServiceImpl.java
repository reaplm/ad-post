package com.adpost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adpost.domain.dao.IMenuDAO;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
import com.adpost.service.IMenuService;


public class MenuServiceImpl implements IMenuService{

	@Autowired
	private IMenuDAO iMenuDAO;

	@Override
	public List<Menu> getAllMenus() {
		return iMenuDAO.getAllMenus();
	}

	@Override
	public Menu getMenu(int id) {
		return iMenuDAO.getMenu(id);
	}

	@Override
	public void updateMenu(Menu menu) {
		iMenuDAO.updateMenu(menu);
	}

	@Override
	public void insertMenu(Menu menu) {
		iMenuDAO.insertMenu(menu);
	}

	@Override
	public List<SubMenu> getAllSubMenus() {
		return iMenuDAO.getAllSubMenus();
	}

	@Override
	public SubMenu getSubMenu(int id) {
		return iMenuDAO.getSubMenu(id);
	}

	@Override
	public void updateSubMenu(SubMenu subMenu) {
		iMenuDAO.updateSubMenu(subMenu);
	}

	@Override
	public void insertSubMenu(SubMenu submenu) {
		iMenuDAO.insertSubMenu(submenu);
	}

	@Override
	public List<Menu> getAllMenus(String menuType) {
		return iMenuDAO.getAllMenus(menuType);
	}

	@Override
	public  void deleteMenu(Menu menu) {
		iMenuDAO.deleteMenu(menu);	
	}

	@Override
	public boolean deleteSubMenu(SubMenu subMenu) {
		// TODO Auto-generated method stub
		return iMenuDAO.deleteSubMenu(subMenu);	
	}

	@Override
	public List<SubMenu> getAllSubMenus(int menuId) {
		return iMenuDAO.getAllSubMenus(menuId);
	}

	@Override
	public List<Menu> getMenusByStatus(String menuStatus) {
		return iMenuDAO.getMenusByStatus(menuStatus);
	}

	@Override
	public List<Menu> getMenusByType(String menuType) {
		return iMenuDAO.getMenusByType(menuType);
	}

	@Override
	public SubMenu getSubMenuById(int id) {
		return iMenuDAO.getSubMenuById(id);
	}
	
}
