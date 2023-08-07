package com.hibernate_practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableObjects {
	public static void main(String[] args) {
		Configuration config = new Configuration();
        config.configure();
        SessionFactory factory=config.buildSessionFactory();
        Student student=new Student();
        student.setName("Sataski");
        student.setCity("GKP");
        student.setAddress("mainMarket");
        Certificate certi=new Certificate();
        certi.setCourse("Hibernate");
        certi.setDuration("1month");
        
        student.setCerti(certi);
        Session session=factory.openSession();
        Transaction trans=session.beginTransaction();
        //save the objects
        session.save(student);
       // session.save(certi);
        
        //commit into the database
		trans.commit();
		session.close();
		factory.close();
	}

}
