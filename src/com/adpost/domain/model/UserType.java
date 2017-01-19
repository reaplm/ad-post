package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {
	@Id
	@GeneratedValue
	@Column(name="pk_user_type_id")
	private int userTypeId;
	@Column(name="user_type_name")
	private String userTypeName;
	@Column(name="user_type_desc")
	private String userTypeDesc;

	public int getUserTypeId(){
		return this.userTypeId;
	}
	public void setUserType(int userTypeId){
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName(){
		return this.userTypeName;
	}
	public void setUserTypeName(String userTypeName){
		this.userTypeName = userTypeName;
	}
	public String getUserTypeDesc(){
		return this.userTypeDesc;
	}
	public void setUserTypeDesc(String userTypeDesc){
		this.userTypeDesc = userTypeDesc;
	}
}
