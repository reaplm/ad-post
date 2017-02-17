package com.adpost.domain.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;

public interface IAdvertDAO {
	
	
	public List<Advert> getAllAdverts();
	public Advert getAdvert(int id);
	public void updateAdvert(Advert advert);
	public void insertAdvert(Advert advert);
	public void deleteAdvert(Advert advert);
	public void insertAdvertDetail(AdvertDetail advertDetail);
}
