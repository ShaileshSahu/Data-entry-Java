package com.project.m;

import java.awt.List;
import java.util.ArrayList;

import Model.Database;
import Model.Person;

public class PersonTableModel extends javax.swing.table.AbstractTableModel {

	private ArrayList<Person> db;
	private String[] colNam ={"Serial No.","Name","Password","Age","Occupation","ID","Gender"};
	
	public String getColumnName(int column) {
		
		return colNam[column];
		
		
	}
	public PersonTableModel()
	{
		

	}
	



	


public void setData(ArrayList<Person> db) {
	
		
		this.db = db;
		
	}
	
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Person person = db.get(row);
		
		switch(col)
		{
		case 1:
			return person.getName();
			
		case 2:
			 return person.getPass();
			 
		case 3:
			return person.getAge();
		case 4:
			return person.getEmp1();
			 
		case 5:
			return person.getId();
			
		case 6:
			return person.getGender();
			
			
		}
		return null;
	}

	

}
