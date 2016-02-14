package repositories;

import dbPackage.DataBaseProvider;
import interfaces.IOrderRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.CustomOrderView;
import Entities.Order;


public class OrderRepository implements IOrderRepository{
	
	public OrderRepository() {
	}
	
	public List<CustomOrderView> GetCustomOrderView()
	{
		String sql = "SELECT o.OrderId, "
				+ "cus.CustomerId, "
				+ "cus.FirstName, "
				+ "cus.LastName, "
				+ "cus.PassportNumber, "
				+ "film.FilmId, "
				+ "film.Name as FilmName, "
				+ "o.Created, "
				+ "o.RentExpires, "
				+ "o.Returned, "
				+ "cus.PhoneNumber, "
				+ "(datediff(o.RentExpires,o.Created) * film.RentCost) as TotalAmount "
				+ "from fmdat.order as o "
				+ "left join fmdat.customer as cus ON o.CustomerId = cus.CustomerId "
				+ "left join fmdat.films as film on o.FilmId = film.FilmId";
				try {
			Statement s = DataBaseProvider.GetNewStatement();
			List<CustomOrderView> list = new ArrayList<CustomOrderView>();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()){
				CustomOrderView tmp = new CustomOrderView(rs);
				list.add(tmp);
			}
			if (list.isEmpty())	{
				return null;
			}
			s.close();
			return list;

	     } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void Create(Order model){
		java.sql.Date data1 = new java.sql.Date(model.getCreated().getTime());
		java.sql.Date data2 = new java.sql.Date(model.getRentExpires().getTime());
	     String sql = "INSERT INTO fmdat.Order "+
	     "(OrderId,CustomerId,FilmId,Created,RentExpires,Returned)"
	    		 +" VALUES ("
	                + "'" + model.getOrderId() + "'" +","
	                + "'" + model.getCustomerId() + "'" +","
	                + "'" + model.getFilmId() + "'" +","
	               // + "'" + model.getEmployeeId()+ "'" +","
	                + "'" + data1+ "'" +","
	                + "'" + data2+ "'" +","
	                + "'" + (model.isReturned()?1:0)+ "'" +")";
	     System.out.println("SQL - CreateOrder");
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
			                //+ "EmployeeId = '" + model.getEmployeeId()+ "'" +","
			                + "Created = '" + model.getCreated()+ "'" + ")"
			                + "RentExpires = '" + model.getRentExpires()+ "'" + ")"
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
		Statement s = DataBaseProvider.GetNewStatement();
		List<Order> ordersList = new ArrayList<Order >();
		try {
			
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
