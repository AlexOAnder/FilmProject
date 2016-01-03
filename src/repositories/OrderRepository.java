package repositories;

import dbPackage.DataBaseProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Order;


public class OrderRepository {
	
	public OrderRepository() {
	}
	
	public void Create(Order model){
	     String sql = "INSERT INTO fmdat.Order "+
	     "(OrderId,CustomerId,FilmId,EmployeeId,Created,RentExpired,RentStartDate,TotalAmount,Returned)"
	    		 +" VALUES ("
	                + "'" + model.getOrderId() + "'" +","
	                + "'" + model.getCustomerId() + "'" +","
	                + "'" + model.getFilmId() + "'" +","
	                + "'" + model.getEmployeeId()+ "'" +","
	                + "'" + model.getCreated()+ "'" +","
	                + "'" + model.getRentExpires()+ "'" +","
	                + "'" + model.getRentStartDate()+ "'" +","
	                + "'" + model.getTotalAmount()+ "'" +","
	                + "'" + model.isReturned()+ "'" + ")";
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Update (Order model){
		String sql = "UPDATE fmdat.Order SET "
			                + "CustomerId = '" + model.getCustomerId()+ "'" +","
			                + "FilmId = '" + model.getFilmId()+ "'" +","
			                + "EmployeeId = '" + model.getEmployeeId()+ "'" +","
			                + "Created = '" + model.getCreated()+ "'" + ")"
			                + "RentStartDate = '" + model.getRentStartDate()+ "'" + ")"
			                + "RentExpired = '" + model.getRentExpires()+ "'" + ")"
			                + "TotalAmount = '" + model.getTotalAmount()+ "'" + ")"
			                + "Returned = '" + model.isReturned()+ "'" + ")"
			                + " WHERE OrderId = "+ model.getOrderId() ;
	     try {
			ExecuteWithNoResult(sql);
	     } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Delete (Order model){
		String sql = "DELETE fmdat.Order WHERE OrderId = "+ model.getOrderId() ;
		try {
			ExecuteWithNoResult(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> GetAll() throws Exception{
		String sql = "SELECT * FROM fmdat.Order;";
		return GetResultSetList(sql);
	}
	
	public Order GetById(int id) throws Exception{
		String sql = "SELECT * FROM fmdat.Order Where OrderId = "+id+" ;";
		List<Order> result = GetResultSetList(sql);
		if (result == null){
			return null;
		}
		if (result.size()>1){
			throw new Exception("Wrong number of customers! More than 1 - > Owibka v logike bd");
		}
		
		return result.get(0);
	}
	
	public List<Order> GetByName(String name) throws Exception{
		
		String sql = "SELECT * FROM fmdat.Order Where Name like /%"+name+"/% ;";
		List<Order> result = GetResultSetList(sql);
		return result;
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

	private List<Order> GetResultSetList(String sql) throws Exception
	{
		List<Order> ordersList = new ArrayList<Order >();
		try {
			Statement s = DataBaseProvider.GetNewStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()){
				Order tmp = new Order(rs);
				ordersList.add(tmp);
			}
			if (ordersList.isEmpty())	{
				return null;
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;	
	}

}
