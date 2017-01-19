package com.adpost.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name="pk_cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="url")
	private String url;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
	@JsonManagedReference
	List<SubCategory> subCategory;
	
	public void setCatId(int catId){
		this.catId = catId;
	}
	public int getCatId(){
		return this.catId;
	}
	public void setCatName(String catName){
		this.catName = catName;
	}
	public String getCatName(){
		return this.catName;
	}
	public void setCatDesc(String catDesc){
		this.catDesc = catDesc;
	}
	public String getCatDesc(){
		return this.catDesc;
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
	public void setSubCategory(List<SubCategory> subCategory){
		this.subCategory = subCategory;
	}
	public List<SubCategory> getSubCategory(){
		return this.subCategory;
	}
}
