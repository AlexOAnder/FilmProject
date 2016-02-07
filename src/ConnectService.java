import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Entities.Order;
import interfaces.*;
import repositories.*;

public class ConnectService extends UnicastRemoteObject implements IConnectService{

	private ICustomerRepository _customerRepository;
	private IOrderRepository _orderRepository;
	private IFilmRepository _filmRepository;
	private IEmployeeRepository _employeeRepository;

	public ConnectService() throws RemoteException {
		// thats bad, but i think it's better than call connectservice with those repositories
		// otherwise we dont use IoC container here 
		this._customerRepository = new CustomerRepository();
		this._orderRepository = new OrderRepository();
		this._filmRepository = new FilmRepository();
		this._employeeRepository = new EmployeeRepository();
	}

	
	public List<Order> GetOrders()	{
		List<Order> orderList = new ArrayList<Order>();

		Order o1 = new Order();
		o1.setFilmId(1);
		o1.setOrderId(2);
		o1.setReturned(false);
		orderList.add(o1);
		
		return orderList;
	}
	
	public String[] GetFilmsList()	{
		String[] ss = {"a","b","c"};
		return ss;
	}
	
	public void AddNewOrder(Order order)	{
		
	}
	
	public void UpdateOrderStatusById(int id,int status){
		
	}
}
