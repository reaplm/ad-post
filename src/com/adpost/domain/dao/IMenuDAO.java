package com.adpost.domain.dao;

import java.util.List;

import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;
import com.adpost.domain.model.enumerated.MenuType;

public interface IMenuDAO {
	
	public List<Menu> getAllMenus();
	/**
	 * Get all sub-menus belonging to a particular parent
	 * @return
	 */
	public List<SubMenu> getAllSubMenus(int menuId);
	public List<Menu> getAllMenus(String menuType);
	public Menu getMenu(int id);
	public void updateMenu(Menu menu);
	public void insertMenu(Menu menu);
	public void deleteMenu(Menu menu);
	
	public List<SubMenu> getAllSubMenus();
	public SubMenu getSubMenu(int id);
	public void updateSubMenu(SubMenu subMenu);
	public void insertSubMenu(SubMenu subMenu);
	public boolean deleteSubMenu(SubMenu menu);
}
