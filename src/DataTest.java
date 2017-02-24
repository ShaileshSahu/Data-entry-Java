import Model.AgeCategary;
import Model.Database;
import Model.EmploymentCategary;
import Model.Gender;
import Model.Person;

public class DataTest {

	public static void main(String ar[]) throws Exception
	{
	Database base = new Database();
	
	
	
	base.connect();
	
	base.addPerson(new Person("shailesh","1232@123",AgeCategary.adult,EmploymentCategary.Employed,"12432",Gender.male));
	base.addPerson(new Person("shailesh","1232@123",AgeCategary.adult,EmploymentCategary.Employed,"12465432",Gender.male));
	base.save();
	base.disconnect();
	
	}
	
	
}
