package com.adpost.domain.model;

import java.io.Serializable;
import java.util.List;


public class FileUpload implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int menuId;
	private int subMenuId;
	private String adLocation;
	private String adSubject;
	private String adBody;
	private String contactNo;
	private String contactEmail;
	//Group Information
	private String groupCdnUrl;
	private String groupUuid;
	private int groupCount;
	private int groupSize;
	//File Information
	private List<String> uuid;//this the individual file ids
	private List<String> cdnUrl;
	private List<Integer> size;
	private List<String> name;
	
	private String uploadCareUrl;
	

	
	public int getSubMenuId(){
		return this.subMenuId;
	}
	public void setSubMenuId(int subMenuId){
		this.subMenuId = subMenuId;
	}
	public int getMenuId(){
		return this.menuId;
	}
	public void setMenuId(int menuId){
		this.menuId = menuId;
	}
	public String getAdLocation(){
		return this.adLocation;
	}
	public void setAdLocation(String adLocation){
		this.adLocation = adLocation;
	}
	public String getAdSubject(){
		return this.adSubject;
	}
	public void setAdSubject(String adSubject){
		this.adSubject =adSubject;
	}
	public String getAdBody(){
		return this.adBody;
	}
	public void setAdBody(String adBody){
		this.adBody = adBody;
	}
	public String getContactNo(){
		return this.contactNo;
	}
	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}
	public String getContactEmail(){
		return this.contactEmail;
	}
	public void setContactEmail(String contactEmail){
		this.contactEmail = contactEmail;
	}
	//Group 
	public void setGroupUuid(String groupUuid){
		this.groupUuid = groupUuid;
	}
	public String getGroupUuid(){
		return this.groupUuid;
	}
	public void setGroupCount(int groupCount){
		this.groupCount = groupCount;
	}
	public int getGroupCount(){
		return this.groupCount;
	}
	public void setGroupSize(int groupSize){
		this.groupSize = groupSize;
	}
	public int getGroupSize(){
		return this.groupSize;
	}
	public void setGroupCdnUrl(String groupCdnUrl){
		this.groupCdnUrl = groupCdnUrl;
	}
	public String getGroupCdnUrl(){
		return this.groupCdnUrl;
	}
	//Individual files
	public void setCdnUrl(List<String> cdnUrl){
		this.cdnUrl = cdnUrl;
	}
	public List<String> getCdnUrl(){
		return this.cdnUrl;
	}
	public void setUuid(List<String> uuid){
		this.uuid = uuid;
	}
	public List<String> getUuid(){
		return this.uuid;
	}
	public void setName(List<String> name){
		this.name = name;
	}
	public List<String> getName(){
		return this.name;
	}
	public void setSize(List<Integer> size){
		this.size = size;
	}
	public List<Integer> getSize(){
		return this.size;
	}
	public void setUploadCareUrl(String uploadCareUrl){
		this.uploadCareUrl = uploadCareUrl;
	}
	public String getUploadCareUrl(){
		return this.uploadCareUrl;
	}
}
