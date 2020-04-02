package org.lanqiao.entity;

import java.util.Date;

//import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import jdk.jfr.Percentage;

public class Student {
	@NumberFormat(pattern="##,##")//#是数字，”，”是分隔符
	private int id;
	private String name;
	private int age;
	private Address address ;
	
//	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")//格式化前台传递来的数据
	private Date time;
	
	public Student(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return id+"-"+name+"-"+address.getHomeAddress()+"-"+address.getSchoolAddress();
	}
}	
