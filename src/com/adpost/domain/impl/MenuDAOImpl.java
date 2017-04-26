package com.adpost.domain.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.adpost.domain.dao.IMenuDAO;
import com.adpost.domain.dao.IUserDAO;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.Role;
import com.adpost.domain.model.SubMenu;
import com.adpost.domain.model.enumerated.MenuStatus;
import com.adpost.domain.model.enumerated.MenuType;
import com.adpost.hibernate.dao.HibernateUtil;

@Repository
public class MenuDAOImpl implements IMenuDAO{

	@Override
	public List<Menu> getAllMenus() {
		List<Menu> results = null;
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from Menu");
			results = (List<Menu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in List<Menu> getAllMenus(): "+e);
		}
		return results;
	}
	@Override
	public Menu getMenu(int id) {
		List<Menu> results = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Menu"
				+ " where menuId = :id");
		query.setParameter("id", id);
		results = (List<Menu>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		if(results.size() != 1){return null;}
		else{return results.get(0);}
	}
	@Override
	public void updateMenu(Menu menu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(menu);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public void insertMenu(Menu menu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(menu);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public List<SubMenu> getAllSubMenus() {
		List<SubMenu> results = null;
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from SubMenu");
			results = (List<SubMenu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in List<SubMenu> getAllSubMenus(): "+e);
		}
		return results;
	}
	@Override
	public SubMenu getSubMenu(int id) {
		List<SubMenu> results = null;

			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from SubMenu"
					+ " where subMenuId = :id");
			query.setParameter("id", id);
			results = (List<SubMenu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
			if(results.size() != 1){return null;}
			else{return results.get(0);}

	}
	@Override
	public void updateSubMenu(SubMenu subMenu) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertSubMenu(SubMenu subMenu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(subMenu);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public List<Menu> getAllMenus(String menuType) {
		List<Menu> results = null;
		MenuType type = MenuType.valueOf(menuType.toUpperCase());
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from Menu"
					+ " where menuType = :menuType");
			query.setParameter("menuType", type);
			results = (List<Menu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in getAllMenus(int menuType) : "+e);
		}
		return results;
	}
	@Override
	public void deleteMenu(Menu menu) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(menu);
			session.getTransaction().commit();
			session.close();
			
		}
		catch(Exception e){
			System.out.println("Exception in void deleteMenu(Menu menu): \n" + e);
		}
	}
	@Override
	public boolean deleteSubMenu(SubMenu menu) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<SubMenu> getAllSubMenus(int menuId) {
		List<SubMenu> results = null;
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from SubMenu"
					+ " where menu.menuId = :menuId");
			query.setParameter("menuId", menuId);
			results = (List<SubMenu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in List<SubMenu> getAllSubMenus(int menuId): "+e);
		}
		return results;
	}
	@Override
	public List<Menu> getMenusByStatus(String menuStatus) {
		List<Menu> results = null;
		MenuStatus status = MenuStatus.valueOf(menuStatus);
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from Menu"
					+ " where menuStatus = :menuStatus");
			query.setParameter("menuStatus", status);
			results = (List<Menu>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in List<SubMenu> getAllSubMenus(int menuId): "+e);
		}
		return results;
	}
	@Override
	public List<Menu> getMenusByType(String menuType) {
		List<Menu> result = null;
		MenuType type = MenuType.valueOf(menuType);
		 try{
			 Session session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
			 Query query = session.createQuery("From Menu"
			 		+ " Where menuType = :menuType");
			 query.setParameter("menuType", type);
			 result = (List<Menu>)query.list();
			 session.getTransaction().commit();
			 session.flush();
			 session.close();
		 }
		 catch(Exception e){
			 System.out.println("Exception caught in getMenuByMenuType DAO: " + e);
		 }
		 return result;
	}

}
