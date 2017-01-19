package com.adpost.domain.model.enumerated;

public enum UserRole {
	ROLE_ADMIN(1),
	ROLE_USER(2);
	
	private int userRole;
	
	private UserRole(final int userRole){
		this.userRole = userRole;
	}
	
	public int getUserRole(){
		return this.userRole;
	}

	public String getName(){
		return this.name();
	}
}
