package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="sub_category")
public class SubCategory {
	@Id
	@GeneratedValue
	@Column(name="pk_sub_cat_id")
	private int subCatId;
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="sub_cat_desc")
	private String subCatDesc;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cat_id", nullable=false)
	@JsonBackReference
	private Category category;
	
	public void setSubCatId(int subCatId){
		this.subCatId = subCatId;
	}
	public int getSubCatId(){
		return this.subCatId;
	}
	public void setSubCatName(String subCatName){
		this.subCatName = subCatName;
	}
	public String getSubCatName(){
		return this.subCatName;
	}
	public void setSubCatDesc(String subCatDesc){
		this.subCatDesc = subCatDesc;
	}
	public String getSubCatDesc(){
		return this.subCatDesc;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setCategory(Category category){
		this.category = category;
	}
	public Category getCategory(){
		return this.category;
	}
}
