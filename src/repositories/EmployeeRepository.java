package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Customer;
import Entities.Employee;
import Entities.Employee;
import dbPackage.DataBaseProvider;
import interfaces.IEmployeeRepository;
import interfaces.IRepository;

public class EmployeeRepository implements IEmployeeRepository{
	
	public EmployeeRepository() {
	}
	
	public void Create(Employee model){
        
	     String sql = "INSERT INTO fmdat.Employee "+
	     "(EmployeeId,FirstName,LastName,CashierPassword,Login,Hired,ContracExpires)"
	    		 +" VALUES ("
	                + "'" + model.getEmployeeId() + "'" +","
	                + "'" + model.getFirstName() + "'" +","
	                + "'" + model.getLastName() + "'" +","
	                + "'" + model.getCashierPassword()+ "'" +","
	                + "'" + model.getLogin()+ "'" +","
	                + "'" + model.getHired()+ "'" +","
	                + "'" + model.getContractExpires()+ "'" + ")";
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Update (Employee model){
		String sql = "UPDATE fmdat.Employee SET "
			                + "FirstName = '" + model.getFirstName()+ "'" +","
			                + "LastName = '" + model.getLastName()+ "'" +","
			                + "CashierPassword = '" + model.getCashierPassword()+ "'" +","
			                + "Login = '" + model.getLogin()+ "'" +","
			                + "Hired = '" + model.getHired()+ "'" + ")"
			                + "ContracExpires = '" + model.getContractExpires()+ "'" 
			                + "WHERE EmployeeId = "+ model.getEmployeeId() ;
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Delete (Employee model){
		String sql = "DELETE fmdat.Employee WHERE EmployeeId = "+ model.getEmployeeId() ;
		try {
			ExecuteWithNoResult(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> GetAll() throws Exception{
		String sql = "SELECT * FROM fmdat.Employee;";
		return GetResultSetList(sql);
	}
	
	public Employee GetById(int id) throws Exception{
		String sql = "SELECT * FROM fmdat.Employee Where EmployeeId = "+id+" ;";
		List<Employee> result = GetResultSetList(sql);
		if (result == null){
			return null;
		}
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		
		return result.get(0);
	}
	
	public Employee GetByLoginAndPass(String login,String pass) throws Exception{
		String sql = "SELECT * FROM fmdat.Employee Where Login = '"+login+"' AND CashierPassword = '"+pass+"';";
		List<Employee> result = GetResultSetList(sql);
		if (result == null){
			return null;
		}
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Error in logic");
		}
		return result.get(0);
	}
	
	public Employee GetByIdAndPass(int id,String pass) throws Exception{
		
		String sql = "SELECT * FROM fmdat.Employee Where EmployeeId = "+ id +"AND CashierPassword = "+pass+" ;";
		List<Employee> result = GetResultSetList(sql);
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		return result.get(0);
	}
	
	private void ExecuteWithNoResult(String sql) throws Exception{
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			s.executeUpdate(sql);
			s.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
	    }
	}

	private List<Employee> GetResultSetList(String sql) throws Exception
	{
		List<Employee> employeesList = new ArrayList<Employee >();
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()){
				Employee tmp = new Employee(rs);
				employeesList.add(tmp);
			}
			if (employeesList.isEmpty())	{
				return null;
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeesList;	
	}
	
}
