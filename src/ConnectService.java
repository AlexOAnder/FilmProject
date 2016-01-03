import interfaces.*;
import repositories.*;

public class ConnectService {

	private static ICustomerRepository _customerRepository;
	
	public ConnectService(){
		_customerRepository = new CustomerRepository();
	}
	
	
}
