package com.onetomany_mapping;

import java.util.List;


import com.onetoone_mapping.Answer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class QuestionOneToMany {
	@Id
	@Column(name="question_id")
    private int questionId;
    private String question;
    @OneToMany
    private List<AnswerManyToOne> answers;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "QuestionOneToMany [questionId=" + questionId + ", question=" + question + ", answer=" + answers + "]";
	}
	public QuestionOneToMany(int questionId, String question, List<AnswerManyToOne> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	public List<AnswerManyToOne> getAnswer() {
		return answers;
	}
	public void setAnswer(List<AnswerManyToOne> answers) {
		this.answers = answers;
	}
	public QuestionOneToMany() {
		super();
		// TODO Auto-generated constructor stub
	}


}
