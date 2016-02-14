import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entities.CustomOrderView;
import Entities.Customer;
import Entities.Film;
import Entities.Order;
import interfaces.*;
import repositories.*;

public class ConnectService extends UnicastRemoteObject implements IConnectService {

	private ICustomerRepository _customerRepository;
	private IOrderRepository _orderRepository;
	private IFilmRepository _filmRepository;
	private IEmployeeRepository _employeeRepository;

	public ConnectService() throws RemoteException {
		// thats bad, but i think it's better than call connectservice with
		// those repositories
		// otherwise we dont use IoC container here
		this._customerRepository = new CustomerRepository();
		this._orderRepository = new OrderRepository();
		this._filmRepository = new FilmRepository();
		this._employeeRepository = new EmployeeRepository();
	}

	public List<Order> GetOrders() {
		List<Order> orderList = new ArrayList<Order>();
		Order o1 = new Order();
		o1.setFilmId(1);
		o1.setOrderId(2);
		o1.setReturned(false);
		orderList.add(o1);

		return orderList;
	}

	public List<Film> GetFilmsList() {
		try {
			return _filmRepository.GetAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CustomOrderView> GetCustomOrderViewList() {
		try {
			return _orderRepository.GetCustomOrderView();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void AddNewCustomOrderView(CustomOrderView order) throws RemoteException {
		Customer currentCustomer = null;
		try {
			System.out.println("Start Create order method");
			
			currentCustomer = _customerRepository.GetByPassportNumber(order.PassportNumber);
			if (currentCustomer == null) {
				// create new Customer
				Customer cus = new Customer();
				cus.setFirstName(order.CustomerFirstName);
				cus.setLastName(order.CustomerLastName);
				cus.setPassportNumber(order.PassportNumber);
				cus.setPhoneNumber(order.PhoneNumber);
				_customerRepository.Create(cus);
				currentCustomer = _customerRepository.GetByPassportNumber(order.PassportNumber);
			} 
			// get Customer with PassportNumber
			if (currentCustomer == null) {
				System.out.println("Add customer's function didn't add any data!");
			} else {
				Order newOrder = new Order();
				newOrder.setCustomerId(currentCustomer.getCustomerId());
				newOrder.setCreated(order.Created);
				newOrder.setEmployeeId(0);
				newOrder.setFilmId(order.FilmId);
				newOrder.setRentExpires(order.RentExpires);			
				newOrder.setReturned(false);
				newOrder.setCreated(new Date());
				System.out.println("Add new order - with that customerId:" + currentCustomer.getCustomerId());
				_orderRepository.Create(newOrder);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RemoteException("Sql add new order failed");
		}

	}

	public void UpdateOrderStatus(int orderId)
	{
		_orderRepository.UpdateReturnedStatusById(orderId,1);
	}
	
	public boolean GetStatusConnect() throws RemoteException {
		System.out.println("Check Status of the RMI Connect");
		return true;
	}
}
