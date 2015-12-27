package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Store {

	public int StoreId;
	public String Address;
	public String Name;
	
	public Store(ResultSet rs) throws SQLException	{
		StoreId = rs.getInt("StoreId");
		Address = rs.getString("Address");
		Name = rs.getString("Name");
	}
}
