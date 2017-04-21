package com.adpost.domain.model.enumerated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum MenuStatus {
	ACTIVE(1),
	INACTIVE(2);
	
	private int menuStatus;
	
	private MenuStatus(final int menuStatus){
		this.menuStatus = menuStatus;
	}
	
	public int getMenuStatus(){
		return this.menuStatus;
	}

	public String getName(){
		return this.name();
	}

	
}
