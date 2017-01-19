package com.adpost.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.adpost.domain.model.enumerated.UserStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="app_user")
public class AppUser {
	@Id
	@GeneratedValue
	@Column(name = "pk_user_id")
	private int userId;
	
	@OneToOne(mappedBy="appUser", cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	private UserDetail userDetail;
	
	private String password; 
	
	private String email;
	
	@Column(name = "password_used")
	private int passwordUsed;
	
	@Column(name = "user_status")
	private UserStatus userStatus;
	
	@ElementCollection
	private List<Role> roles;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="appUser")
	@JsonBackReference
	private List<Advert> advert;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="appUser")
	@JsonBackReference
	private List<AdComment> adComments;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="appUser")
	@JsonBackReference
	private List<AdShare> adShares;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="appUser")
	@JsonBackReference
	private List<AdLike> adLikes;
	
	@Column(name = "user_created_date")
	private Date userCreatedDate;
	@Column(name = "pass_expiry_date")
	private Date passExpiryDate;
	@Column(name = "last_login_date")
	private Date lastLoginDate;
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setPasswordUsed(int passwordUsed){
		this.passwordUsed = passwordUsed;
	}
	public int getPasswordUsed(){
		return this.passwordUsed;
	}
	public void setRole(List<Role> roles){
		this.roles = roles;
	}
	public List<Role> getRole(){
		return this.roles;
	}
	public String getRoleToString(){
		String roles = "";
		for(Role role:this.roles){
			roles += role.getRoleName() + ",";
		}
		return roles;
	}
	public void setUserStatus(UserStatus userStatus){
		this.userStatus = userStatus;
	}
	public UserStatus getUserStatus(){
		return this.userStatus;
	}
	public void setCreateDate(Date userCreatedDate){
		this.userCreatedDate = userCreatedDate;
	}
	public Date getUserCreateDate(){
		return this.userCreatedDate ;
	}
	public void setLastLoginDate(Date lastLoginDate){
		this.lastLoginDate = lastLoginDate;
	}
	public Date getLastLoginDate(){
		return this.lastLoginDate ;
	}
	public void setPassExpiryDate(Date passExpiryDate){
		this.passExpiryDate= passExpiryDate;
	}
	public Date getPassExpiryDate(){
		return this.passExpiryDate;
	}
	public void setUserDetail(UserDetail userDetail){
		this.userDetail = userDetail;
	}
	public UserDetail getUserDetail(){
		return this.userDetail;
	}
}
