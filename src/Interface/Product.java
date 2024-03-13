package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code Product} interface represents a product in a distributed system.
 * It provides methods to retrieve the price and serial number of the product.
 */
public interface Product extends Remote {
	/**
	 * Returns the price of the product.
	 * 
	 * @return the current price of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getPrice() throws RemoteException;

	/**
	 * Returns the serial number of the product.
	 * 
	 * @return the serial number of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getSN() throws RemoteException;
}
