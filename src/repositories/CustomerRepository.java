package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Customer;
import dbPackage.DataBaseProvider;

public class CustomerRepository implements ICustomerRepository{

	public CustomerRepository() {
		
	}
	
	public void Create(Customer model)	{
	        
	     String sql = "INSERT INTO fmdat.Customer "+
	     "(CustomerId,FirstName,LastName,PassportNumber,Discount) VALUES ("
	                + "'" + model.getCustomerId() + "'" +","
	                + "'" + model.getFirstName() + "'" +","
	                + "'" + model.getLastName() + "'" +","
	                + "'" + model.getPassportNumber()+ "'" +","
	                + "'" + model.getDiscount()+ "'" + ")";
	     try {
			DataBaseProvider.Statement.execute(sql);
	     } catch (SQLException e) {
			e.printStackTrace();
	     }
	}

	public void Update (Customer model){
		String sql = "UPDATE fmdat.Customer SET "
			                + "FirstName = '" + model.getFirstName()+ "'" +","
			                + "LastName = '" + model.getLastName()+ "'" +","
			                + "PassportNumber = '" + model.getPassportNumber()+ "'" +","
			                + "Discount = '" + model.getDiscount()+ "'" + ")"
			                + "WHERE CustomerId = "+ model.getCustomerId() ;
	     try {
			DataBaseProvider.Statement.executeUpdate(sql);
	     } catch (SQLException e) {
			e.printStackTrace();
	     }
	}
	
	public void Delete (Customer model){
		String sql = "DELETE fmdat.Customer WHERE CustomerId = "+ model.getCustomerId() ;
		try {
			DataBaseProvider.Statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> GetAll() throws Exception{
		String sql = "SELECT * FROM fmdat.Customer;";
		return ExecuteQuery(sql);
	}
	
	public Customer GetById(int id) throws Exception{
		String sql = "SELECT * FROM fmdat.Customer Where CustomerId = "+id+" ;";
		List<Customer> result = ExecuteQuery(sql);
		if (result == null){
			return null;
		}
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		
		return result.get(0);
	}
	
	public Customer GetByPassportNumber(String passNum) throws Exception{
		
		String sql = "SELECT * FROM fmdat.Customer Where PassportNumber = "+passNum+" ;";
		List<Customer> result = ExecuteQuery(sql);
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		return result.get(0);
	}
	
	private List<Customer> ExecuteQuery(String sql) throws Exception
	{
		List<Customer> customerList = new ArrayList<Customer >();
		try {
			ResultSet rs = DataBaseProvider.GetNewStatement().executeQuery(sql);
			while (rs.next()){
				Customer tmp = new Customer(rs);
				customerList.add(tmp);
			}
			if (customerList.isEmpty())	{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;	
	}
	
	
}
