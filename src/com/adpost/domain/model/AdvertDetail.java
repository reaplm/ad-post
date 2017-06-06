package com.adpost.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="advert_detail")
public class AdvertDetail {
	@Id
	@GeneratedValue
	@Column(name="pk_ad_detail_id")
	private int adDetailId;

	@OneToOne
	@JoinColumn(name="fk_advert_id")
	private Advert advert;
	
	@Column(name="ad_subject")
	private String adSubject;
	@Column(name="ad_body")
	private String adBody;
	@Column(name="ad_location")
	private String adLocation;
	@Column(name="contact_no")
	private String contactNo;
	@Column(name="contact_email")
	private String contactEmail;
	
	@OneToMany(mappedBy="advertDetail", fetch=FetchType.LAZY, 
			cascade=CascadeType.REMOVE)
	private List<AdPicture> adPictures;
	
	public AdvertDetail(){
		this.adPictures = new ArrayList<AdPicture>();
	}
	public int getAdDetailId(){
		return this.adDetailId;
	}
	public void setAdvert(Advert advert){
		this.advert = advert;
	}
	
	public Advert getAdvert(){
		return this.advert;
	}
	public void setAdDetailId(int advertId){
		this.adDetailId =advertId;
	}
	
	public String getAdSubject(){
		return this.adSubject;
	}
	public void setAdSubject(String adSubject){
		this.adSubject = adSubject;
	}
	public String getAdBody(){
		return this.adBody;
	}
	public void setAdBody(String adBody){
		this.adBody = adBody;
	}
	public String getAdLocation(){
		return this.adLocation;
	}
	public void setAdLocation(String adLocation){
		this.adLocation = adLocation;
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
	public List<AdPicture> getAdPictures(){
		return this.adPictures;
	}
	public void setAdPictures(List<AdPicture> adPictures){
		this.adPictures = adPictures;
	}
}
