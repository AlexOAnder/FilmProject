package interfaces;

import Entities.Employee;

public interface IEmployeeRepository extends IRepository<Employee> {
	Employee GetById(int id) throws Exception;
	Employee GetByIdAndPass(int id,String pass) throws Exception;
	Employee GetByLoginAndPass(String login,String pass) throws Exception;
}
