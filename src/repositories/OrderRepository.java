package repositories;

import dbPackage.DataBaseProvider;
import Entities.Order;

public class OrderRepository {

	private DataBaseProvider provider;
	
	public OrderRepository() {
		provider = DataBaseProvider.GetInstance();
	}
	
	public void Create(Order order)	{
		
	}
	
	public void Update(Order order)	{
			
	}
	
	public void Delete(Order order)	{
		
	}

}
