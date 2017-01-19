package com.adpost.domain.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.adpost.domain.dao.IAdvertDAO;
import com.adpost.domain.dao.IMenuDAO;
import com.adpost.domain.dao.IUserDAO;
import com.adpost.domain.model.Advert;
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
	public void insertAdvert(Advert advert) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(advert);
		session.getTransaction().commit();
		session.close();
		
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

}
