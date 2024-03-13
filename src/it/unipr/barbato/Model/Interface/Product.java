package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code Product} interface represents a product in a distributed system.
 * It provides methods to retrieve the price and serial number of the product.
 * 
 * @author Vincenzo Barbato 345728
 */
public interface Product extends Remote {
	/**
	 * Returns the price of the product.
	 * 
	 * @return The current price of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getPrice() throws RemoteException;

	/**
	 * Returns the serial number of the product.
	 * 
	 * @return The serial number of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getSN() throws RemoteException;
}
