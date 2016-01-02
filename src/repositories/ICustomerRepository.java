package repositories;

import java.util.List;

import Entities.Customer;

public interface ICustomerRepository {

	void Create(Customer model);
	void Update (Customer model);
	void Delete (Customer model);
	List<Customer> GetAll() throws Exception;
	Customer GetById(int id) throws Exception;
	Customer GetByPassportNumber(String passNum) throws Exception;
}
