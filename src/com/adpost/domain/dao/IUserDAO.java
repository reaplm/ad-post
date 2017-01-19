package com.adpost.domain.dao;

import java.util.List;

import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Role;

public interface IUserDAO {

	/**
	 * Get a user object using email and password
	 * @param userName
	 * @param password
	 * @return
	 */
	public AppUser getUser(String email, String password);
	/**
	 * Get user using email
	 * @param 
	 * @return AppUser User
	 */
	public AppUser getUser(String email);
	/**
	 * Get all the users registered in the application
	 * @return
	 */
	public List<AppUser> getAllUsers();
	/**
	 * Update a user's details
	 * @param username
	 * @param password
	 */
	public void updateUser(AppUser user);
	
	public void createUser(AppUser user);
	/**
	 * Check if the email is already registered with another user.
	 * @param email
	 * @return
	 */
	public boolean isValidEmail(String email);
	public boolean isValidUser(String email, String password);
	
	public List<Role> getUserRole(int userId);
	public AppUser getUser(int id);
}
