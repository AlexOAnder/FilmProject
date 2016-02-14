package Entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class Employee extends User implements Serializable{

	private int _employeeId;
	private String _cashierPassword;
	private Date _hired;
	private Date _contractExpires;
	private String _login;

	public Employee(ResultSet rs) throws SQLException {
		setEmployeeId(rs.getInt("EmployeeId"));
		setFirstName(rs.getString("FirstName"));
		setLastName(rs.getString("LastName"));
		setLogin(rs.getString("Login"));
		setCashierPassword(rs.getString("CashierPassword"));
		setHired(rs.getDate("Hired"));
		setContractExpires(rs.getDate("ContractExpires"));
	}

	private void setEmployeeId(int employeeId) {
		_employeeId = employeeId;
	}

	public int getEmployeeId()	{
		return _employeeId;
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
		if (_hired != null)
			if (contractExpires.after(_hired))
				_contractExpires = contractExpires;
	}

	public String getLogin() {
		return _login;
	}

	public void setLogin(String _login) {
		this._login = _login;
	}
}
