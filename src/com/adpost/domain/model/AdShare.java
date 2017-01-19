package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="advert_share")
public class AdShare {
	@Id
	@GeneratedValue
	@Column(name="pk_ad_share_id")
	private int adShareId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_advert_id", nullable=false)
	@JsonManagedReference
	private Advert advert;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user_id", nullable=false)
	@JsonManagedReference
	private AppUser appUser;
	
	public void setAdShareId(int adShareId){
		this.adShareId = adShareId;
	}
	public int getAdShareId(){
		return this.adShareId;
	}
	public void setAdvert(Advert advert){
		this.advert = advert;
	}
	public Advert getAdvert(){
		return this.advert;
	}
	public void setAppUser(AppUser appUser){
		this.appUser = appUser;
	}
	public AppUser getUserId(){
		return this.appUser;
	}
}
