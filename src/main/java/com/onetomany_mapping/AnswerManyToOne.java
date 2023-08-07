package com.onetomany_mapping;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AnswerManyToOne {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	
	@ManyToOne
    private QuestionOneToMany questionn;
	public int getAnswerId() {
		return answerId;
	}
	@Override
	public String toString() {
		return "AnswerOneToMany [answerId=" + answerId + ", answer=" + answer + ", question=" + questionn + "]";
	}
	public AnswerManyToOne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerManyToOne(int answerId, String answer, QuestionOneToMany question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionn = question;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public QuestionOneToMany getQuestion() {
		return questionn;
	}
	public void setQuestion(QuestionOneToMany question) {
		this.questionn = question;
	}
	
	

}
