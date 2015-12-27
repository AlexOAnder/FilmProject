package data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Employee extends User{

	public String CashierPassword;
	public Date Hired;
	public Date ContractExpires;

	public Employee(ResultSet rs) throws SQLException	{
		Id = rs.getInt("EmployeeId");
		FirstName = rs.getString("FirstName");
		LastName = rs.getString("LastName");
		CashierPassword = rs.getString("CashierPassword");
		Hired = rs.getDate("Hired");
		ContractExpires = rs.getDate("ContractExpires");
	}
}
