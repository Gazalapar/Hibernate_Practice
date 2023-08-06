package com.hibernate_practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchOperation {
	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session =factory.openSession();
	//using get() using id fetching the student data
	//get() involves select query at instant
	Student student=(Student)session.get(Student.class, 1);
	System.out.println(student);
	//it have the proxy object hits the database when asked for any value
    Address address=(Address)session.load(Address.class, 1);     	
	}

}
