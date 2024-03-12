package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductsList extends Remote{
	
	/**
	 * Return the element with passed sn like parameters
	 * @param sn of element
	 * @return Return element of list
	 * @throws RemoteException
	 */
	Product getProduct(int sn) throws RemoteException;
}
