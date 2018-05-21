package com.wang.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jason.util.DBHelper;

/**
 * Application Lifecycle Listener implementation class InitApplicationListener
 *
 */
@WebListener
public class InitApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitApplicationListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	DBHelper.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			DBHelper.init("classpath:/jdbc.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	
}
