package com.hibernate_practice;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="myStudents")
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(name="city_name")
	private String city;
	@Transient
	private String Address;
	@Embedded
	private Certificate certi;
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, String city, String address, Certificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		Address = address;
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", Address=" + Address + ", certi=" + certi
				+ "]";
	}
}
