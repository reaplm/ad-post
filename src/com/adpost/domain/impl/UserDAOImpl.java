package com.adpost.domain.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.adpost.domain.dao.IUserDAO;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Role;
import com.adpost.hibernate.dao.HibernateUtil;

@Repository
public class UserDAOImpl implements IUserDAO{

	/**
	 * Get a user object using userName and password
	 * @param userName
	 * @param password
	 * @return
	 */
	@Override
	public AppUser getUser(String email, String password){
		List<AppUser> results = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		//check customers
		Query query = session.createQuery("from AppUser"
				+ " where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		results = (List<AppUser>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		if(results.size() != 1){return null;}
		else{return results.get(0);}

	}
	/**
	 * Get user using userName only
	 * @param userName
	 * @return
	 */
	@Override
	public AppUser getUser(String email){
		List<AppUser> results = null;
		boolean found = false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		//check customers
		Query query = session.createQuery("from AppUser"
				+ " where email = :email");
		query.setParameter("email", email);
		results = (List<AppUser>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		if(results.size() != 1){return null;}
		else{return results.get(0);}
	}
	/**
	 * Get all the users registered in the application
	 * @return
	 */
	@Override
	public List<AppUser> getAllUsers(){
		List<AppUser> results = null;
		
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			//check customers
			Query query = session.createQuery("from AppUser");
			results = (List<AppUser>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in getAllUsers: "+e);
		}
		return results;

	}

	/**
	 * Update a user's details
	 * @param 
	 */
	@Override
	public void updateUser(AppUser user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Check if the email is already registered with another user.
	 * @param email
	 * @return true if the email exists otherwise return false
	 */
	@Override
	public boolean isValidEmail(String email){
		List<AppUser> results = null;
		boolean valid = true;
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Query query = session.createQuery("from AppUser"
				+ " where email = :email");
		query.setParameter("email", email);
		results = (List<AppUser>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		if(results.size() > 0){
			valid = false;
		}
		return valid;
	}
	/**
	 * Create a new user
	 * @param 
	 * 
	 */
	@Override
	public void createUser(AppUser user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public boolean isValidUser(String email, String password) {
		List<AppUser> results = null;
		boolean valid = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from AppUser"
				+ " where email = :email "
				+ "and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		results = (List<AppUser>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		if(results.size() == 1){
			valid = true;
		}
		
		return valid;
	}
	@Override
	public List<Role> getUserRole(int userId) {
		List<Role> results = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			//check customers
			Query query = session.createQuery("from Role "
					+ " where user_typ = 'emp'");
			results = (List<Role>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("getAllEmployees: "+e);
		}
		return results;
	}
	/**
	 * Get user using id
	 * @param id
	 * @return
	 */
	@Override
	public AppUser getUser(int id) {
			List<AppUser> results = null;
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from AppUser"
					+ " where userId = :id");
			query.setParameter("id", id);
			results = (List<AppUser>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
			if(results.size() != 1){return null;}
			else{return results.get(0);}

		}
	
}
