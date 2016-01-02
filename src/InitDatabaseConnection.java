import data.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBPackage.DataBaseProvider;

public class InitDatabaseConnection {

	public InitDatabaseConnection() throws SQLException{
		
		if (DataBaseProvider.conn != null)
		{
			try {
				//Statement statement = DataBaseProvider.conn.createStatement();
			
				//ResultSet res = statement.executeQuery("SELECT * FROM fmdat.films");
				// for insert update
				//myStatement.executeUpdate(); 
				/*while (res.next())
				{
					System.out.println(res.getString("id")+" "+res.getString("Name"));
				}*/
				PreparedStatement prepStatement = DataBaseProvider.conn.prepareStatement("Select * FROM fmdat.customer");
				ResultSet res = prepStatement.executeQuery();
	
				while (res.next())
				{
					Customer customer = new Customer(res);
					System.out.println(customer.getCustomerId()+" "
								+customer.getFirstName()+" "
								+customer.getLastName()+" "
								+customer.getPassportNumber()+" "
								+customer.getDiscount());
				}
			} catch (SQLException e) {
				DataBaseProvider.conn.rollback();
				e.printStackTrace();
			}
		}
	}
}
