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

	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
