package com.adpost.domain.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {
	private int menuId;
	private int subMenuId;
	private String adLocation;
	private String adSubject;
	private String adBody;
	private String contactNo;
	private String contactEmail;
	private String fileName;
	private CommonsMultipartFile file;
	
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
	public String getFileName(){
		return this.fileName;
	}
	public void setFile(String fileName){
		this.fileName = fileName;
	}
	public CommonsMultipartFile getFile(){
		return this.file;
	}
	public void setFile(CommonsMultipartFile file){
		this.file = file;
		this.fileName = file.getOriginalFilename();
	}
}
