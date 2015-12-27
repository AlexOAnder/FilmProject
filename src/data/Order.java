package data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

// need for the SQL table
public class Order {
	public int OrderId;
	public int StoreId;
	public int CustomerId;
	public int EmployeeId;
	public Date Created;
	public Date RentFrom;
	public Date RentExpires;
	
	public Order(ResultSet rs) throws SQLException{
		
		OrderId = rs.getInt("OrderId");
		StoreId = rs.getInt("StoreId");
		CustomerId = rs.getInt("CustomerId");
		EmployeeId = rs.getInt("EmployeeId");
		Created = rs.getDate("Created");
		RentFrom = rs.getDate("RentFrom");
		RentExpires = rs.getDate("RentExpires");
	}
}
