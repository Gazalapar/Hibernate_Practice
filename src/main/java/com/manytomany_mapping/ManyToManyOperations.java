package com.manytomany_mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyOperations {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Employee object
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		
		emp1.setEid(54);
		emp1.setName("Rahul");
		
		
		emp2.setEid(67);
		emp2.setName("Dravid");
		
		
		//Project object
		  Project project1=new Project();
		  Project project2=new Project();
		  
		  project1.setPid(23);
		  project1.setProjectName("Hospital Management System");
		  
		  project2.setPid(89);
		  project2.setProjectName("Note taking app");
		  
		  List<Employee> emp=new ArrayList<>();
		  List<Project> project=new ArrayList<>();
		  
		  emp.add(emp1);
		  emp.add(emp2);
		  
		  project.add(project1);
		  project.add(project2);
		  
		  
		  emp1.setProjects(project);
		  project2.setEmployees(emp);
		  
		  
		  Session session=factory.openSession();
		  Transaction trans=session.beginTransaction();
		  session.save(emp1);
		  session.save(emp2);
		  session.save(project1);
		  session.save(project2);
		  
		  trans.commit();
		  session.close();
		  
		  factory.close();
	}


}
