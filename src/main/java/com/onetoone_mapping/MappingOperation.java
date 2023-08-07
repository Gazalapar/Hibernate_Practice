package com.onetoone_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingOperation {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		//Question object creation
		Question question=new Question();
	    question.setQuestionId(234);
	    question.setQuestion("What is java?");
	    
	    //Create Answer object
	    Answer answer=new Answer();
	    answer.setAnswer("java is a secure language");
	    answer.setAnswerId(345);
	    answer.setQuestion(question);
	    
	    question.setAnswer(answer);
	    System.out.println(question.getQuestion());
	    System.out.println(question.getAnswer().getAnswer());
	    //fetch the session object to begin the transaction
	    Session session =factory.openSession();
	   Transaction trans=session.beginTransaction();
	   session.save(question);
	   session.save(answer);
	   trans.commit();
	   session.close();
	   factory.close();
	   
	    
	}

}
