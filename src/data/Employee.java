package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class Employee extends User {

	private String _cashierPassword;
	private Date _hired;
	private Date _contractExpires;

	public Employee(ResultSet rs) throws SQLException {
		Id = rs.getInt("EmployeeId");
		FirstName = rs.getString("FirstName");
		LastName = rs.getString("LastName");
		_cashierPassword = rs.getString("CashierPassword");
		_hired = rs.getDate("Hired");
		_contractExpires = rs.getDate("ContractExpires");
	}

	public String getCashierPassword() {
		return _cashierPassword;
	}

	public void setCashierPassword(String cashierPassword) {
		_cashierPassword = cashierPassword;
	}

	public Date getHired() {
		return _hired;
	}

	public void setHired(Date hired) {
		_hired = hired;
	}

	public Date getContractExpires() {
		return _contractExpires;
	}

	public void setContractExpires(Date contractExpires) {
		_contractExpires = contractExpires;
	}
}
