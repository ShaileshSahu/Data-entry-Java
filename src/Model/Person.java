package Model;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5025467683846834754L;
	private static int count =0;
	private String name;
	private String pass;
	private AgeCategary age;
	private EmploymentCategary emp1;
	private String id;
	private Gender gender;
	private int serial;
	
	public Person(String name,String pass,AgeCategary age,EmploymentCategary emp1,String id,Gender gender)
	{
		this.name= name;
		this.pass= pass;
		this.age= age;
		this.emp1 = emp1;
		this.id = id;
		this.gender = gender;
		
		this.serial = count;
		count++;
		
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
	public AgeCategary getAge() {
		return age;
	}
	public void setAge(AgeCategary age) {
		this.age = age;
	}
	public EmploymentCategary getEmp1() {
		return emp1;
	}
	public void setEmp1(EmploymentCategary emp1) {
		this.emp1 = emp1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}


