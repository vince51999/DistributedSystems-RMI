package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BuyersList extends Remote{
	/**
	 * Subscribe to list of products buyers
	 * 
	 * @param o	the remote object of the client
	 * @throws RemoteException
	 */
	void subscribe(final ProductOffer o) throws RemoteException;
	
	/**
	 * Unsubscribe to list of products buyers
	 * 
	 * @param o	the remote object of the client
	 * @throws RemoteException
	 */
	void unsubcribe(final ProductOffer o) throws RemoteException;
}
