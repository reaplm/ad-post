package com.adpost.domain.model.enumerated;

public enum AdvertStatus {
	PUBLISHED(1),
	APPROVED(2),
	SUBMITTED(3),
	REJECTED(4);
	
	private int userAdStatus;
	
	private AdvertStatus(final int userAdStatus){
		this.userAdStatus = userAdStatus;
	}
	
	public int getUserRole(){
		return this.userAdStatus;
	}

	public String getName(){
		return this.name();
	}
}
