package com.adpost.domain.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.adpost.domain.dao.IAdvertDAO;
import com.adpost.domain.dao.IMenuDAO;
import com.adpost.domain.dao.IUserDAO;
import com.adpost.domain.model.AdPicture;
import com.adpost.domain.model.Advert;
import com.adpost.domain.model.AdvertDetail;
import com.adpost.domain.model.AppUser;
import com.adpost.domain.model.Menu;
import com.adpost.domain.model.Role;
import com.adpost.domain.model.SubMenu;
import com.adpost.domain.model.enumerated.MenuType;
import com.adpost.hibernate.dao.HibernateUtil;

@Repository
public class AdvertDAOImpl implements IAdvertDAO{

	@Override
	public List<Advert> getAllAdverts() {
		List<Advert> results = null;
		try{ 
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Query query = session.createQuery("from Advert");
			results = (List<Advert>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception in public List<Advert> getAllAdverts(): \n"+e);
		}
		return results;
	}
	@Override
	public Advert getAdvert(int id) {
		List<Advert> results = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Advert"
				+ " where advertId = :id");
		query.setParameter("id", id);
		results = (List<Advert>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		if(results.size() != 1){return null;}
		else{return results.get(0);}
	}
	@Override
	public void updateAdvert(Advert advert) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(advert);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public int insertAdvert(Advert advert) {
		//int id = 0;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)session.save(advert);
		//id = advert.getAdvertId();
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	@Override
	public void deleteAdvert(Advert advert) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(advert);
			session.getTransaction().commit();
			session.close();
			
		}
		catch(Exception e){
			System.out.println("Exception in void deleteAdvert(Advert advert): \n" + e);
		}
	}
	@Override
	public int  insertAdvertDetail(AdvertDetail advertDetail) {
		int id = 0;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			id = (int)session.save(advertDetail);
			session.getTransaction().commit();
			session.close();
			
		}
		catch(Exception e){
			System.out.println("Exception in insertAdvertDetail(AdvertDetail advertDetail): \n" + e);
		}
		return id;
	}
	@Override
	public AdvertDetail getAdvertDetail(int id) {
		List<AdvertDetail> results = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from AdvertDetail"
				+ " where adDetailId = :id");
		query.setParameter("id", id);
		results = (List<AdvertDetail>)query.list();
		session.flush();
		session.getTransaction().commit();
		session.close();
		if(results.size() != 1){return null;}
		else{return results.get(0);}
	}
	@Override
	public void updateAdvertDetail(AdvertDetail advertDetail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(advertDetail);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public int insertAdPicture(AdPicture adPicture) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int)session.save(adPicture);
		session.getTransaction().commit();
		session.close();
		return id;
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
		List<AdPicture> result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try{
			Query query = session.createQuery("from AdPicture"
					+ " where advertDetail.adDetailId = :detailId");
			query.setParameter("detailId", detailId);
			result = (List<AdPicture>)query.list();
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("Exception occured while fetching images.\n" + e);
			e.printStackTrace();
		}
		return result;
	}
	
}
