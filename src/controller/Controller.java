package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.project.m.FomEvent;

import Model.AgeCategary;
import Model.Database;
import Model.EmploymentCategary;
import Model.Gender;
import Model.Person;

public class Controller {
	Database db = new Database();
	
	public java.util.ArrayList<Person> getPeople()
	{
		return db.getPeople();
	}
	
	public void removeItem(int index)
	{
		db.removeItem(index);
	}
	
	public void addController(FomEvent e) {
	
		String name=e.getName();
		String pass= e.getPass();
		String age =e.getAge();
		String emp1= e.getEmp1();
	String id = e.getId();
	String gender= e.getGender();
	AgeCategary ageCat = null;
	
	if(age.equals("under 18"))
	{
		ageCat = AgeCategary.child;
	}
	else if(age.equals("b/w 18to65"))
	{
		ageCat= AgeCategary.adult;
	}
	else if(age.equals("above 65"))
	
	{
		ageCat = AgeCategary.senior;
	}
	else 
	{
		System.err.println("Error in Age Categary");
	}
	
	EmploymentCategary empCat;
	
	if(emp1.equals("Employed"))
	{
		empCat = EmploymentCategary.Employed;
	}
	else if(emp1.equals("Unemployed"))
	{
		empCat = EmploymentCategary.unemployed;
	}
	else if(emp1.equals("HouseWife"))
	{
		empCat = EmploymentCategary.housewive;
		
	}
	
	else
	{
		empCat= EmploymentCategary.govtoffical;
	}
	
	Gender gn ;
	
	if(gender.equals("Male"))
	{
		gn = Gender.male;
	}
	else 
	{
		gn = Gender.female;
	}
	
	Person person = new Person(name,pass,ageCat,empCat,id,gn);
	
	
	
	db.addPerson(person);
	}
	
	public void toSaveFile(File file) throws IOException
	{
		db.toSaveFile(file);
	}
	
	public void toOpenFile(File file) throws IOException, ClassNotFoundException
	{
		db.toLoadFile(file);
	}

}
