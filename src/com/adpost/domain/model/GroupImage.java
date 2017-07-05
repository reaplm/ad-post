package com.adpost.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="group")
public class GroupImage extends AdPicture{
	private String groupCdnUrl;
	private int count;
	private int groupSize;
	private String groupUuid;
	
	public String getgroupUuid(){
		return this.groupUuid;
	}
	public void setGroupUuid(String groupUuid){
		this.groupUuid = groupUuid;
	}
	public void setGroupCdnUrl(String groupCdnUrl){
		this.groupCdnUrl = groupCdnUrl;
	}
	public String getGroupCdnUrl(){
		return this.groupCdnUrl;
	}
	public int getGroupSize(){
		return this.groupSize;
	}
	public void setGroupSize(int groupSize){
		this.groupSize = groupSize;
	}
	public int getCount(){
		return this.count;
	}
	public void setCount(int count){
		this.count = count;
	}

}
