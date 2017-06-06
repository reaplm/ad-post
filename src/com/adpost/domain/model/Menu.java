package com.adpost.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adpost.domain.model.enumerated.MenuStatus;
import com.adpost.domain.model.enumerated.MenuType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="menu")
public class Menu  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="pk_menu_id")
	private int menuId;
	
	@Column(name="menu_name")
	private String menuName;
	
	@Column(name="menu_desc")
	private String menuDesc;
	
	@Enumerated(EnumType.STRING)
	@Column(name="menu_type")
	private MenuType menuType = MenuType.UNCLASSIFIED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="menu_status")
	private MenuStatus menuStatus = MenuStatus.ACTIVE;
	
	@Column(name="menu_url")
	private String url;
	
	@Column(name="icon")
	private String icon;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="menu",
			cascade=CascadeType.REMOVE)
	@JsonBackReference
	List<SubMenu> subMenu;
	
	public void setMenuId(int menuId){
		this.menuId = menuId;
	}
	public int getMenuId(){
		return this.menuId;
	}
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	public String getMenuName(){
		return this.menuName;
	}
	public void setMenuDesc(String menuDesc){
		this.menuDesc = menuDesc;
	}
	public String getMenuDesc(){
		return this.menuDesc;
	}
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
	public MenuType getMenuType(){
		return this.menuType;
	}
	public void setMenuType(MenuType menuType){
		this.menuType = menuType;
	}
	
	public MenuStatus getMenuStatus(){
		return this.menuStatus;
	}
	public void setMenuStatus(MenuStatus menuStatus){
		this.menuStatus = menuStatus;
	}
	
	public void setSubMenu(List<SubMenu> subMenu){
		this.subMenu = subMenu;
	}
	public List<SubMenu> getSubMenu(){
		return this.subMenu;
	}
}
