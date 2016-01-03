package interfaces;

import Entities.Order;

public interface IOrderRepository extends IRepository<Order>{

	Order GetById(int id) throws Exception;
}
