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
	 * Return the element with passed sn like parameters
	 * @param sn of element
	 * @return Return element of list
	 * @throws RemoteException
	 */
	Product getProduct(int sn) throws RemoteException;
}
