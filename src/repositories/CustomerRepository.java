package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Customer;
import Entities.Customer;
import dbPackage.DataBaseProvider;
import interfaces.ICustomerRepository;
import interfaces.IRepository;

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
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
	     }
	}

	public void Update(Customer model){
		String sql = "UPDATE fmdat.Customer SET "
			                + "FirstName = '" + model.getFirstName()+ "'" +","
			                + "LastName = '" + model.getLastName()+ "'" +","
			                + "PassportNumber = '" + model.getPassportNumber()+ "'" +","
			                + "Discount = '" + model.getDiscount()+ "'" + ")"
			                + "WHERE CustomerId = "+ model.getCustomerId() ;
		try {
			ExecuteWithNoResult(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Delete (Customer model){
		String sql = "DELETE fmdat.Customer WHERE CustomerId = "+ model.getCustomerId() ;
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> GetAll() throws Exception{
		String sql = "SELECT * FROM fmdat.Customer;";
		return GetResultsList(sql);
	}
	
	public Customer GetById(int id) throws Exception{
		String sql = "SELECT * FROM fmdat.Customer Where CustomerId = "+id+" ;";
		List<Customer> result = GetResultsList(sql);
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
		List<Customer> result =  GetResultsList(sql);
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

	private List<Customer> GetResultsList(String sql) throws Exception
	{
		List<Customer> customersList = new ArrayList<Customer >();
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()){
				Customer tmp = new Customer(rs);
				customersList.add(tmp);
			}
			if (customersList.isEmpty())	{
				return null;
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customersList;	
	}	
}
