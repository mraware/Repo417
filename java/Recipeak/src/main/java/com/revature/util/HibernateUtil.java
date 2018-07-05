package com.revature.util;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.MetadataSources;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.springframework.stereotype.Component;


	@Component
	public class HibernateUtil {

	    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    private static SessionFactory sessionFactory = null;
	    private static Session session = null;

	    public static Session getHibernateSession() {

	        if (sessionFactory == null) {
	            //Building session factory
	            try {
	                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	            } catch(Exception e) {
	                //Could not build session factory from hibernate.cfg.xml properties
	                e.printStackTrace();
	            }
	        }

	        if (session == null || !session.isOpen()) {
	            //opening new session
	            session = sessionFactory.openSession();
	        }

	        return session;
	    }

	}

