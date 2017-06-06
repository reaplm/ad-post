package com.adpost.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adpost.domain.model.AdPicture;
import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;

public interface IAdvertService {
	
	
public List<Advert> getAllAdverts();

	public Advert getAdvert(int id);
	public void updateAdvert(Advert advert);
	public int insertAdvert(Advert advert);
	
	//Advert Detail
	public int insertAdvertDetail(AdvertDetail advertDetail);
	public AdvertDetail getAdvertDetail(int id);
	public void updateAdvertDetail(AdvertDetail advertDetail);
	//Advert Pictures
	public int insertAdPicture(AdPicture adPicture);
	public AdPicture getAdPicture(int id);
	public void updateAdPicture(AdPicture adPicture);
}
