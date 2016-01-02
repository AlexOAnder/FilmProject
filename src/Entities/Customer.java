package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class Customer extends User{

	private int _customerId;
	private String _passportNumber;
	private int _discount;
	// constructor for the mapping
	public Customer(ResultSet rs) throws SQLException	{
		setCustomerId(rs.getInt("CustomerId"));
		setFirstName(rs.getString("FirstName"));
		setLastName(rs.getString("LastName"));
		setPassportNumber(rs.getString("PassportNumber"));
		setDiscount(rs.getInt("Discount"));
	}
	@Override
	public String toString(){
		String res = " CustomerId:"+getCustomerId()+" \n"
				+" FirstName: "+getFirstName()+" \n"
				+" LastName: "+getLastName()+" \n"
				+" PassportNumber: "+getPassportNumber()+" \n"
				+" Discount: "+getDiscount()+" \n"
				+"###############################\n";
		return res;
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
	public int getCustomerId() {
		return _customerId;
	}
	public void setCustomerId(int customerId) {
		this._customerId = customerId;
	}
}
