package com.adpost.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="advert_comment")
public class AdComment {
	@Id
	@GeneratedValue
	@Column(name="pk_ad_comment_id")
	private int adCommentId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_advert_id", nullable=false)
	@JsonManagedReference
	private Advert advert;
	
	@Column(name="comment_text")
	private String commentText;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user_id", nullable=false)
	@JsonManagedReference
	private AppUser appUser;
	
	public void setAdCommentId(int adCommentId){
		this.adCommentId = adCommentId;
	}
	public int getAdCommentIdId(){
		return this.adCommentId;
	}
	public void setAdvert(Advert advert){
		this.advert = advert;
	}
	public Advert getAdvert(){
		return this.advert;
	}
	public String getCommentText(){
		return this.commentText;
	}
	public void setCommentText(String CommentText){
		this.commentText = CommentText;
	}
	public void setAppUser(AppUser appUser){
		this.appUser = appUser;
	}
	public AppUser getAppUser(){
		return this.appUser;
	}
}
