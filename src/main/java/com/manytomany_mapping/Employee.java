package com.manytomany_mapping;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {
	private String name;
	@Id
	private int eid;
	//one employee can have many projects
	@ManyToMany
	@JoinTable(name="empo_learn")
	private List<Project> projects;
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Employee(String name, int eid, List<Project> projects) {
		super();
		this.name = name;
		this.eid = eid;
		this.projects = projects;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
