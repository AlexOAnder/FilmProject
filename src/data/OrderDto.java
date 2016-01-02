package data;

import java.util.Date;
// need for representation of the Order's object
public class OrderDto {

	public int Id;
	public Store Store;
	public Customer Customer;
	public Employee Employee;
	public Date Created;
	public Date RentFrom;
	public Date RentExpires;
	public final int getId() {
		return Id;
	}
	public final void setId(int id) {
		Id = id;
	}
	public final Store getStore() {
		return Store;
	}
	public final void setStore(Store store) {
		Store = store;
	}
	public final Customer getCustomer() {
		return Customer;
	}
	public final void setCustomer(Customer customer) {
		Customer = customer;
	}
	public final Employee getEmployee() {
		return Employee;
	}
	public final void setEmployee(Employee employee) {
		Employee = employee;
	}
	public final Date getCreated() {
		return Created;
	}
	public final void setCreated(Date created) {
		Created = created;
	}
	public final Date getRentFrom() {
		return RentFrom;
	}
	public final void setRentFrom(Date rentFrom) {
		RentFrom = rentFrom;
	}
	public final Date getRentExpires() {
		return RentExpires;
	}
	public final void setRentExpires(Date rentExpires) {
		RentExpires = rentExpires;
	}
}
