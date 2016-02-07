import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

	
	public void GetOrders()	{
		
	}
	
	public void GetFilmsList()	{
		
	}
	
	public void AddNewOrder(Order order)	{
		
	}
	
	public void UpdateOrderStatusById(int id,int status){
		
	}
}
