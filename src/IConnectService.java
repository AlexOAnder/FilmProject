import java.rmi.Remote;
import java.rmi.RemoteException;

import Entities.Order;

public interface IConnectService extends Remote{

	public void GetOrders() throws RemoteException;
			
	public void GetFilmsList()	throws RemoteException;
	
	public void AddNewOrder(Order order) throws RemoteException;
	
	public void UpdateOrderStatusById(int id,int status) throws RemoteException;
}
