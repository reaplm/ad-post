package com.adpost.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.adpost.hibernate.dao.HibernateUtil;
 
public class HibernateContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) { 
		HibernateUtil.buildSessionFactory(); 
		System.out.println("HIBERNATE SESSION FACTORY INITIALIZED"); 
	} 
	public void contextDestroyed(ServletContextEvent sce) { 
	
		if (HibernateUtil.getSessionFactory()!=null) { 
			HibernateUtil.getSessionFactory().close(); 
		} 
		// This manually deregisters JDBC driver, which prevents Tomcat 7 
		//from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
           
			try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistering jdbc driver: " + driver);
                //LOG.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
            	System.out.println("Error deregistering driver: " + driver);
                //LOG.log(Level.SEVERE, String.format("Error deregistering driver %s", driver), e);
            }
        }
		System.out.println("HIBERNATE SESSION FACTORY DESTROYED"); 
	}
	
}
