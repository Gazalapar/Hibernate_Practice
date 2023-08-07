package com.onetomany_mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		//create object for Question
		QuestionOneToMany question=new QuestionOneToMany();
		question.setQuestionId(89);
		question.setQuestion("what is java?");
		
		
		//create answer object 
		AnswerManyToOne answer1 =new AnswerManyToOne();
		answer1.setAnswerId(90);
        answer1.setAnswer("java is a robust language.");
        answer1.setQuestion(question);
		
		AnswerManyToOne answer2=new AnswerManyToOne();
		answer2.setAnswerId(87);
		answer2.setAnswer("java is object oriented language.");
	    answer2.setQuestion(question);
		
		AnswerManyToOne answer3=new AnswerManyToOne();
		answer3.setAnswerId(86);
		answer3.setAnswer("used in web application ,mobile application.");
		answer3.setQuestion(question);
		
		List <AnswerManyToOne> answers=new ArrayList<AnswerManyToOne>();
		answers.add(answer1);
		answers.add(answer2);
		answers.add(answer3);
		
		//fetching the answers
		System.out.println(question.getQuestion());
		for(AnswerManyToOne ans:answers) {
			System.out.println(ans.getAnswer());
		}
		
		question.setAnswer(answers);
		
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		session.save(question);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		trans.commit();
		session.close();
		factory.close();


		
		
		
		
		
		
		
	}

}
