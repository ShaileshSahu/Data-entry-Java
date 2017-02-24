package Model;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Database {


	private ArrayList<Person> people;
	private ObjectOutputStream fout;
	private Connection con;
	
	public Database()
	{
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person person)
	{
		people.add(person);
	}
	
	public ArrayList <Person> getPeople()
	{
		return people;
	}
	
	public void connect() throws Exception
	{
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		throw new Exception("Driver not found");
		}
		
		String url ="jdbc:mysql://localhost:3306/student";
		
	 con = DriverManager.getConnection(url,"root","root");
		

		
		System.out.println(con);
			
		
	}
	
	public void save() throws SQLException
	{
		String query="select count(*) as count from students where id=?";
		
	java.sql.PreparedStatement st = con.prepareStatement(query);
	
	for(Person person:people)
	{
	Integer id= new Integer(person.getId());
	
	st.setInt(1,id);
	ResultSet result =(ResultSet) st.executeQuery();
	
	result.next();
	
	int count =result.getInt(1);
	System.out.println(count);
	}
	
	}
	public void disconnect() throws SQLException
	{
	con.close();
	}
	
	public void removeItem(int index)
	{
		people.remove(index);
	}
	
	public void toSaveFile(File file) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(file);
		fout = new ObjectOutputStream(fos);
		Person[] person = people.toArray(new Person[people.size()]);
		
		fout.writeObject(person);
		fout.close();
	}
	
	public void toLoadFile(File file) throws FileNotFoundException, ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream(file);
		try {
			ObjectInputStream fon = new ObjectInputStream(fin);
			Person[] person =(Person[]) fon.readObject();
			
			people.clear();
			people.addAll(Arrays.asList(person));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
