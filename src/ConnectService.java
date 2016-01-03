import interfaces.*;
import repositories.*;

public class ConnectService {

	private static ICustomerRepository _customerRepository;
	private static IOrderRepository _orderRepository;
	private static IFilmRepository _filmRepository;
	private static IEmployeeRepository _employeeRepository;
	
	public ConnectService(){
		_customerRepository = new CustomerRepository();
		_orderRepository = new OrderRepository();
		_filmRepository = new FilmRepository();
		_employeeRepository = new EmployeeRepository();
	}
	
	
}
