package com.adpost.service;

import java.util.List;

import com.adpost.domain.model.Menu;
import com.adpost.domain.model.SubMenu;

public interface IMenuService {
	/**
	 * Get a list of all menus in the application
	 * @return
	 */
	public List<Menu> getAllMenus();
	/**
	 * Get a list of all menus of type menuType
	 * @param menuType
	 * @return
	 */
	public List<Menu> getAllMenus(String menuType);
	/**
	 * Get menu using id
	 * @param id
	 * @return
	 */
	public Menu getMenu(int id);
	/**
	 * Update an existing menu
	 * @param menu
	 */
	public void updateMenu(Menu menu);
	/**
	 * Create a new menu
	 * @param menu
	 */
	public void insertMenu(Menu menu);
	/**
	 * Delete a menu from the application
	 * @param menu
	 */
	public void deleteMenu(Menu menu);
	/**
	 * Get all sub-menus in the application
	 * @return
	 */
	public List<SubMenu> getAllSubMenus();
	/**
	 * Get all sub-menus belonging to a particular parent
	 * @return
	 */
	public List<SubMenu> getAllSubMenus(int menuId);
	public SubMenu getSubMenu(int id);
	public void updateSubMenu(SubMenu subMenu);
	public void insertSubMenu(SubMenu submenu);
	public boolean deleteSubMenu(SubMenu subMenu);
	public SubMenu getSubMenuById(int id);
	public List<Menu> getMenusByStatus(String menuStatus);
	public List<Menu> getMenusByType(String menuType);
}
