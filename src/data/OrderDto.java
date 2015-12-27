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
}
