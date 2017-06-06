package com.adpost.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="advert")
public class Advert {
	@Id
	@GeneratedValue
	@Column(name="pk_advert_id")
	private int advertId;
	
	@OneToOne(mappedBy="advert", cascade=CascadeType.REMOVE,
			fetch=FetchType.EAGER)
	private AdvertDetail advertDetail; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_sub_menu_id", nullable=false)
	@JsonManagedReference
	private SubMenu subMenu;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_user_id", nullable=false)
	@JsonManagedReference
	private AppUser appUser;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="advert")
	private List<AdComment> adComments;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="advert")
	private List<AdShare> adShares;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="advert")
	private List<AdLike> adLikes;
	
	
	@Column(name="advert_status")
	private AdvertStatus advertStatus = AdvertStatus.SUBMITTED;
	
	@Column(name="published_flag")
	private int publishedFlag;
	@Column(name="approved_flag")
	private int approvedFlag;
	@Column(name="submitted_flag")
	private int submittedFlag;
	@Column(name="rejected_flag")
	private int rejectedFlag;
	
	@Column(name="published_date")
	private Date publishedDate;
	@Column(name="approved_date")
	private Date approvedDate;
	@Column(name="submitted_date")
	private Date submittedDate;
	@Column(name="rejected_date")
	private Date rejectedDate;
	
	public void setAdvertId(int advertId){
		this.advertId = advertId;
	}
	public AdvertDetail getAdvertDetail(){
		return this.advertDetail;
	}
	public void setAdvertDetail(AdvertDetail advertDetail){
		this.advertDetail = advertDetail;
	}
	public int getAdvertId(){
		return this.advertId;
	}
	
	
	public void setAdvertStatus(AdvertStatus advertStatus){
		this.advertStatus = advertStatus;
	}
	public AdvertStatus getAdverStatus(){
		return this.advertStatus;
	}
	public void setPublishedDate(Date publishedDate){
		this.publishedDate = publishedDate;
	}
	public Date getPublishedDate(){
		return this.publishedDate;
	}
	public void setApprovedDate(Date approvedDate){
		this.approvedDate = approvedDate;
	}
	public Date getApprovedDate(){
		return this.approvedDate;
	}
	public void setSubmittedDate(Date submittedDate){
		this.submittedDate = submittedDate;
	}
	public Date getSubmittedDate(){
		return this.submittedDate;
	}
	public void setRejectedDate(Date rejectedDate){
		this.rejectedDate = rejectedDate;
	}
	public Date getRejectedDate(){
		return this.rejectedDate;
	}
	public void setPublishedFlag(int publishedFlag){
		this.publishedFlag = publishedFlag;
	}
	public int getPublishedFlag(){
		return this.publishedFlag;
	}
	public void setApprovedFlag(int approvedFlag){
		this.approvedFlag = approvedFlag;
	}
	public int getApprovedFlag(){
		return this.approvedFlag;
	}
	public void setSubmittedFlag(int submittedFlag){
		this.submittedFlag = submittedFlag;
	}
	public int getSubmittedFlag(){
		return this.submittedFlag;
	}
	public void setRejectedFlag(int rejectedFlag){
		this.rejectedFlag = rejectedFlag;
	}
	public int getRejectedFlag(){
		return this.rejectedFlag;
	}
	public SubMenu getSubMenu(){
		return this.subMenu;
	}
	public void setSubMenu(SubMenu subMenu){
		this.subMenu = subMenu;
	}
	public void setAppUser(AppUser appUser){
		this.appUser = appUser;
	}
	public AppUser getAppUser(){
		return this.appUser;
	}
}
