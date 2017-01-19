package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_detail")
public class UserDetail {
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private AppUser appUser;
	
	@Id
	@GeneratedValue
	@Column(name = "pfk_user_id")
	private int userId;
	
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "post_addr1")
	private String postAddress1;
	@Column(name = "post_addr2")
	private String postAddress2;
	private String street;
	private String surbub;
	private String state;
	@Column(name = "post_code")
	private String postCode;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "office_no")
	private String officeNo;
	@Column(name = "fax_no")
	private String faxNo;
	@Column(name = "bus_name")
	private String busName;
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setPostAddress1(String postAddress1){
		this.postAddress1 = postAddress1;
	}
	public String getPostAddress1(){
		return this.postAddress1;
	}
	public String getPostAddress2(){
		return this.postAddress2;
	}
	public void setPostAddress2(String postAddress2){
		this.postAddress2 = postAddress2;
	}
	public String getStreet(){
		return this.street;
	}
	public void setStreet(String street){
		this.street= street;
	}
	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getSurbub(){
		return this.surbub;
	}
	public void setSurbub(String surbub){
		this.surbub = surbub;
	}
	public String getPostCode(){
		return this.postCode;
	}
	public void setPostCode(String postCode){
		 this.postCode = postCode;
	}
	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}
	public String getMobileNo(){
		return this.mobileNo;
	}
	public void setOfficeNo(String officeNo){
		this.officeNo = officeNo;
	}
	public String getOfficeNo(){
		return this.officeNo;
	}
	public void setFaxNo(String faxNo){
		this.faxNo = faxNo;
	}
	public String getFaxNo(){
		return this.faxNo;
	}
	public void setBusName(String busName){
		this.busName = busName;
	}
	public String getbusName(){
		return this.busName;
	}
}

