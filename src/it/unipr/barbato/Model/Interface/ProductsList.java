package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The {@code ProductsList} interface represents a list of products.
 * It provides methods to retrieve product information.
 */
public interface ProductsList extends Remote {

	/**
	 * Returns the product with the specified serial number.
	 * 
	 * @param sn the serial number of the product
	 * @return the product with the specified serial number
	 * @throws RemoteException if a remote communication error occurs
	 */
	Product getProduct(int sn) throws RemoteException;

	/**
	 * Returns a list of all possible product serial numbers.
	 * 
	 * @return a list of all possible product serial numbers
	 * @throws RemoteException if a remote communication error occurs
	 */
	ArrayList<Integer> getSNs() throws RemoteException;
}
