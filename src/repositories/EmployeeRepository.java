package repositories;

import java.util.List;

import Entities.Employee;
import dbPackage.DataBaseProvider;
import interfaces.IRepository;

public class EmployeeRepository {

	private DataBaseProvider provider;
	
	public EmployeeRepository() {
		provider = DataBaseProvider.GetInstance();
	}
	
	public Employee GetById(int EmployeeId) {
		return null;
	}

	public List<Employee> GetAll() {
		return null;
	}

	public boolean Insert(Employee model) {
		return false;
	}

	public void Delete(Employee model) {

	}
	
}
