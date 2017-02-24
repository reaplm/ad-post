package com.adpost.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.adpost.domain.model.enumerated.MenuStatus;
import com.adpost.domain.model.enumerated.MenuType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sub_menu")
public class SubMenu {
	@Id
	@GeneratedValue
	@Column(name="pk_sub_menu_id")
	private int subMenuId;
	
	@Column(name="sub_menu_name")
	private String subMenuName;
	
	@Column(name="sub_menu_desc")
	private String subMenuDesc;
	
	@Column(name="url")
	private String url;
	
	@Column(name="icon")
	private String icon;
	
	@Enumerated(EnumType.STRING)
	@Column(name="menu_type")
	private MenuType menuType = MenuType.UNCLASSIFIED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="menu_status")
	private MenuStatus menuStatus = MenuStatus.INACTIVE;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_menu_id", nullable=false)
	@JsonBackReference
	private Menu menu;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JsonBackReference
	List<Advert> advert;
	
	public void setSubMenuId(int subMenuId){
		this.subMenuId = subMenuId;
	}
	public int getSubMenuId(){
		return this.subMenuId;
	}
	public void setSubMenuName(String subMenuName){
		this.subMenuName = subMenuName;
	}
	public String getSubMenuName(){
		return this.subMenuName;
	}
	public void setSubMenuDesc(String subCatDesc){
		this.subMenuDesc = subCatDesc;
	}
	public String getSubMenuDesc(){
		return this.subMenuDesc;
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
	public Menu getMenu(){
		return this.menu;
	}
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	public List<Advert> getAvert(){
		return this.advert;
	}
	public void setAdvert(List<Advert> advert){
		this.advert = advert;
	}
}
