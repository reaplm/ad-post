package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advert_type")
public class AdvertType {
	@Id
	@GeneratedValue
	@Column(name="pk_ad_type_id")
	private int adTypeId;
	
	@Column(name="ad_type_name")
	private String adTypeName;
	
	@Column(name="ad_type_desc")
	private String adTypeDesc;
	
	public void setAdTypeId(int adTypeId){
		this.adTypeId = adTypeId;
	}
	public int getAdTypeId(){
		return this.adTypeId;
	}
	public void setAdTypeName(String adTypeName){
		this.adTypeName= adTypeName;
	}
	public String getAdTypeName(){
		return this.adTypeName;
	}
	public void setAdTypeDesc(String adTypeDesc){
		this.adTypeDesc= adTypeDesc;
	}
	public String getAdTypeDesc(){
		return this.adTypeDesc;
	}
}
