package com.adpost.domain.model.enumerated;


public enum MenuType {
	CATEGORY(1),
	ADMIN(2),
	UNCLASSIFIED(3);
	
	private int menuType;
	
	private MenuType(final int menuType){
		this.menuType = menuType;
	}
	
	public int getMenuType(){
		return this.menuType;
	}

	public String getName(){
		return this.name();
	}
	
}
