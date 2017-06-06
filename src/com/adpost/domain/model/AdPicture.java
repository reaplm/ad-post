package com.adpost.domain.model;

import javax.persistence.Column;
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
public class AdPicture {
	@Id
	@GeneratedValue
	@Column(name="pk_pic_id")
	private int adPictureId;
	
	@ManyToOne
	@JoinColumn(name="fk_detail_id")
	private AdvertDetail advertDetail;
	
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="image_title")
	private String imageTitle;
	@Column(name="image_name")
	private String imageName;
	
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
	public String getImageUrl(){
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	public String getImageTitle(){
		return this.imageTitle;
	}
	public void setImageTitle(String imageTitle){
		this.imageTitle = imageTitle;
	}
	public String getImageName(){
		return this.imageName;
	}
	public void setImageName(String imageName){
		this.imageName = imageName;
	}
	/*public Clob getImage(){
		return this.image;
	}
	public void setImage(Clob image){
		this.image = image;
	}*/
}
