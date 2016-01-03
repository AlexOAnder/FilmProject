package interfaces;

import java.util.List;

import Entities.Customer;

public interface ICustomerRepository extends IRepository<Customer>{

	Customer GetById(int id) throws Exception;
	Customer GetByPassportNumber(String passNum) throws Exception;
}
