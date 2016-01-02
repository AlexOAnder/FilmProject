package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends User{

	public String PassportNumber;
	public int Discount;
	// constructor for the mapping
	public Customer(ResultSet rs) throws SQLException	{
		Id = rs.getInt("CustomerId");
		FirstName = rs.getString("FirstName");
		LastName = rs.getString("LastName");
		PassportNumber = rs.getString("PassportNumber");
		Discount = rs.getInt("Discount");
	}
	public String getPassportNumber() {
		return PassportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		PassportNumber = passportNumber;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
}
