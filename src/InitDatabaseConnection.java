import data.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDatabaseConnection {

	public InitDatabaseConnection() throws SQLException{
		
		DataBaseConnection dbConn = new DataBaseConnection();
		if (dbConn.myConn != null)
		{
			try {
				Statement statement = dbConn.myConn.createStatement();
			
				//ResultSet res = statement.executeQuery("SELECT * FROM fmdat.films");
				// for insert update
				//myStatement.executeUpdate(); 
				/*while (res.next())
				{
					System.out.println(res.getString("id")+" "+res.getString("Name"));
				}*/
				PreparedStatement prepStatement = dbConn.myConn.prepareStatement("Select * FROM fmdat.customer");
				ResultSet res = prepStatement.executeQuery();
	
				while (res.next())
				{
					Customer customer = new Customer(res);
					System.out.println(customer.Id+" "
								+customer.FirstName+" "
								+customer.LastName+" "
								+customer.PassportNumber+" "
								+customer.Discount);
				}
			} catch (SQLException e) {
				dbConn.myConn.rollback();
				e.printStackTrace();
			}
		}
	}
}
