package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends User{

	private String _passportNumber;
	private int _discount;
	// constructor for the mapping
	public Customer(ResultSet rs) throws SQLException	{
		Id = rs.getInt("CustomerId");
		FirstName = rs.getString("FirstName");
		LastName = rs.getString("LastName");
		_passportNumber = rs.getString("PassportNumber");
		_discount = rs.getInt("Discount");
	}
	public String getPassportNumber() {
		return _passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		_passportNumber = passportNumber;
	}
	public int getDiscount() {
		return _discount;
	}
	public void setDiscount(int discount) {
		_discount = discount;
	}
}
