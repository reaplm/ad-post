package com.adpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adpost.domain.dao.IUserDAO;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Role;
import com.adpost.service.IUserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService, UserDetailsService{

	@Autowired
	private IUserDAO iUserDAO;
	/**
	 * Get all the users registered in the application
	 * @param
	 * @return
	 */
	@Override
	public List<AppUser> getAllUsers(){
		return iUserDAO.getAllUsers();
	}
	/**
	 * 
	 * @param String email
	 * @return org.springframework.security.core.userdetails.UserDetails 
	 */
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String email)
	throws UsernameNotFoundException{
		
		//Fetch user from the database
		AppUser user = iUserDAO.getUser(email);
		
		 if ( user == null ) {
	            throw new UsernameNotFoundException( "getUser could not fetch user details" );
	        }
		
		List<GrantedAuthority> authorities = buildUserAuthority(user);
		return buildUserForAuthentication(user, authorities);
	}
	/**
	 * Converts com.adpost.domain.model.AppUser user to
	 * org.springframework.security.core.userdetails.User
	 * @param AppUser user
	 * @param List<GrantedAuthority> authorities
	 * @return
	 */
	private User buildUserForAuthentication(AppUser user,
			List<GrantedAuthority> authorities){
		return new User(user.getEmail(), user.getPassword(), 
				true, true, true, true, authorities);
	}
	/**
	 * Retrieves user roles and returns authorities object
	 * @param AppUser user
	 * @return List<GrantedAuthority>
	 */
	private List<GrantedAuthority> buildUserAuthority(AppUser user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		List<Role> userRoles = user.getRole();
		for(Role role:userRoles){
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}
	@Override
	public boolean isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		return iUserDAO.isValidUser(email, password);
	}
	@Override
	public boolean isValidEmail(String email) {
		return iUserDAO.isValidEmail(email);
	}

	@Override
	public boolean isEqual(String string1, String string2) {
		if(string1.equals(string2)){
			return true;
		}
		else return false;
	}
	/**
	 * Paassword Generator
	 * @return
	 */
	/*@Override
	public String randomPassGen(){
		//random(int count, boolean letters, boolean letters)
		return RandomStringUtils.random(8, true, true);
	}*/

	@Override
	public AppUser getUser(String email) {
		return iUserDAO.getUser(email);
	}
	@Override
	public void updateUser(AppUser user) {
		iUserDAO.updateUser(user);
		
	}
	@Override
	public AppUser getUser(int id) {
		return iUserDAO.getUser(id);
	}
	@Override
	public void createUser(AppUser appUser) {
		iUserDAO.createUser(appUser);
		
	}
}
