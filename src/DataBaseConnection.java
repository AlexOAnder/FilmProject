import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DataBaseConnection{
	public String ConnectionString;
	public Connection myConn = null;
	
	//constructor
	DataBaseConnection(){
		try{
			String url = "jdbc:mysql://localhost/";
			myConn = DriverManager.getConnection(url,"alexoander","12345D");
			// create a statement
			Statement statement = myConn.createStatement();
			boolean res = statement.execute("Select * from fmdat.customer");
			if (res)
				System.out.println("Connected to fmdat");
			else
				System.out.println("Something wrong! Check SQL connect");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Connect to MySql failed!");
		}
	}
}