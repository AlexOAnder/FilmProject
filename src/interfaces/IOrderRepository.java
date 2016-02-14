package interfaces;

import java.util.List;

import Entities.CustomOrderView;
import Entities.Order;

public interface IOrderRepository extends IRepository<Order>{

	Order GetById(int id) throws Exception;
	List<CustomOrderView> GetCustomOrderView();
	void UpdateReturnedStatusById(int orderId,int status);
}
