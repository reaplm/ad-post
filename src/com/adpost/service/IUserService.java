package com.adpost.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adpost.domain.model.AppUser;

public interface IUserService {
	
	
	/**
	 * Get all registered users.
	 * Return a list containing user objects
	 * @param
	 * @return
	 * 
	 */
	public List<AppUser> getAllUsers();

	/**
	 * Check if a userName exists (for registration purposes)
	 * @param userName
	 * @return
	 */
	public boolean isValidUser(String email, String password);
	/**
	 * Check if the email is already registered with another user.
	 * @param email
	 * @return
	 */
	public boolean isValidEmail(String email);
	/**
	 * Return true if both strings are equal
	 * @param string1
	 * @param string2
	 * @return
	 */
	public boolean isEqual(String string1, String string2);
	/**
	 * Spring security authentication
	 * @param email
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException;
	//public String randomPassGen();

	/**
	 * Get a user by email
	 * @param email
	 * @return
	 */
	public AppUser getUser(String email);
	/**
	 * Uodate a user's details
	 * @param user
	 */
	public void updateUser(AppUser user);
	/**
	 * Get user using id
	 * @param id
	 * @return
	 */
	public AppUser getUser(int id);
	public void createUser(AppUser appUser);
}
