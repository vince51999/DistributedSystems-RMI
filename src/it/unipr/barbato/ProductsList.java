package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ProductsList extends Remote{

	/**
	 * Return the element with passed sn like parameters
	 * @param sn of element
	 * @return Return element of list
	 * @throws RemoteException
	 */
	Product getProduct(int sn) throws RemoteException;
	
	/**
	 * Return a list of possible products SN
	 * @return List of SNs
	 * @throws RemoteException
	 */
	ArrayList<Integer> getSNs() throws RemoteException;
}
