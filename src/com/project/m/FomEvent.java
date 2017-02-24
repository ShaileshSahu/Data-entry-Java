package com.project.m;

import java.util.EventObject;

public class FomEvent extends EventObject{
	private String name,pass,age,emp1,id,gender;
	FomEvent(Object sc)
	{
		super(sc);
		
	}
	
	FomEvent(Object sc,String name,String pass,String age,String emp1,String id,String gender)
	{
		super(sc);
		this.name=name;
		this.pass =pass;
		this.age=age;
		this.emp1=emp1;
		this.id = id;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmp1() {
		return emp1;
	}

	public void setEmp1(String emp1) {
		this.emp1 = emp1;
	}

	
	
	
	
	

}
