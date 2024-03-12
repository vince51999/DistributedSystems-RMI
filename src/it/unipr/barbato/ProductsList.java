package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ProductsList extends Remote{
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	Set<Product> getProducts() throws RemoteException;
	
	int size() throws RemoteException;
	
	/**
	 * Return the element with index passed like parameters
	 * @param index of element (start with 0 and end with size()-1)
	 * @return Return element of list
	 * @throws RemoteException
	 */
	Product getProduct(int index) throws RemoteException;
}
