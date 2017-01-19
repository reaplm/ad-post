package com.adpost.domain.model.enumerated;


public enum UserStatus {
	ACTIVE(1),
	INACTIVE(2),
	LOCKED(3),
	SUSPENDED(4),
	BLOCKED(5),
	DELETED(6);
	
	private int userStatus;
	
	private UserStatus(final int userStatus){
		this.userStatus = userStatus;
	}
	
	public int getUserStatus(){
		return this.userStatus;
	}

	public String getName(){
		return this.name();
	}
	
}
