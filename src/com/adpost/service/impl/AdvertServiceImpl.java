package com.adpost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adpost.domain.dao.IAdvertDAO;
import com.adpost.domain.dao.IMenuDAO;
import com.adpost.domain.model.AdPicture;
import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;
import com.adpost.service.IAdvertService;
import com.adpost.service.IMenuService;

public class AdvertServiceImpl implements IAdvertService{
	@Autowired
	private IAdvertDAO iAdvertDAO;
	
	@Override
	public List<Advert> getAllAdverts(){
		return iAdvertDAO.getAllAdverts();
	}
	@Override
	public Advert getAdvert(int id){
		return iAdvertDAO.getAdvert(id);
	}
	@Override
	public void updateAdvert(Advert advert){
		iAdvertDAO.updateAdvert(advert);
	}
	@Override
	public int insertAdvert(Advert advert){
		return iAdvertDAO.insertAdvert(advert);
	}
	@Override
	public int insertAdvertDetail(AdvertDetail advertDetail){
		return iAdvertDAO.insertAdvertDetail(advertDetail);
	}
	@Override
	public AdvertDetail getAdvertDetail(int id) {
		return iAdvertDAO.getAdvertDetail(id);
	}
	@Override
	public void updateAdvertDetail(AdvertDetail advertDetail) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insertAdPicture(AdPicture adPicture) {
		return iAdvertDAO.insertAdPicture(adPicture);

	}
	@Override
	public AdPicture getAdPicture(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateAdPicture(AdPicture adPicture) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<AdPicture> getAdDetailPictures(int detailId) {
		return iAdvertDAO.getAdDetailPictures(detailId);
	}
}
