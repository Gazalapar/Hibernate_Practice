package com.hibernate_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Project started...");

        // SessionFactory 
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        System.out.println(sessionFactory.isClosed());
        //Create the student object
        Student student=new Student();
        //set the values in setter method
     
        student.setName("isha");
        student.setCity("GKp");
        //Checking the values
        System.out.println(student);
        //From the current session we fetched perform the Transaction 
        Transaction trans=session.beginTransaction();
        //Save the student object using the session
        //create Address object
        Address address=new Address();
        address.setCity("GKP");
        address.setStreet("MainCity");
        address.setValid(true);
        address.setX(7.0);
        address.setAddedDate(new Date());
        //save the image
        FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/main/java/picc.jpg");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        byte[] data = null;
		try {
			data = new byte[fis.available()];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			fis.read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(address);
        address.setImage(data);
        session.save(student);
        session.save(address);
        //Commit the transaction if not made the commit the data will not be saved in database
        trans.commit();
        session.close();
        
    }
}

