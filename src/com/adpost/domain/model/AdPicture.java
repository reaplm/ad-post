package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mysql.jdbc.Clob;

@Entity
@Table(name="advert_picture")
@DiscriminatorValue(value="adPicture")
@DiscriminatorColumn(name="group_type", 
	discriminatorType=DiscriminatorType.STRING)
public class AdPicture{
	@Id
	@GeneratedValue
	@Column(name="pk_pic_id")
	private int adPictureId;
	
	@ManyToOne
	@JoinColumn(name="fk_detail_id")
	private AdvertDetail advertDetail;
	
	@Column(name="cdn_url")
	private String cdnUrl;
	private String name;
	private int size;
	private String uuid;
	
	public void setAdvertId(int adPictureId){
		this.adPictureId = adPictureId;
	}
	public int getAdPictureId(){
		return this.adPictureId;
	}
	public void setAdvertDetail(AdvertDetail advertDetail){
		this.advertDetail = advertDetail;
	}
	public AdvertDetail getAdvertDetail(){
		return this.advertDetail;
	}
	public String getCdnUrl(){
		return this.cdnUrl;
	}
	public void setCdnUrl(String cdnUrl){
		this.cdnUrl = cdnUrl;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getUuid(){
		return this.uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public int getSize(){
		return this.size;
	}
	public void setSize(int size){
		this.size = size;
	}
}
