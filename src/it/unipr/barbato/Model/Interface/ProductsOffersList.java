package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code OffersList} interface represents the list of client offers in a distributed system.
 * It provides methods to subscribe and un-subscribe from the offers list.
 * 
 * @author Vincenzo Barbato 345728
 */
public interface ProductsOffersList extends Remote{
	/**
	 * Subscribe to list of products buyers
	 * 
	 * @param offer	The remote object of the client
	 * @throws RemoteException If a remote communication error occurs
	 */
	void subscribe(final ProductOffer offer) throws RemoteException;
	
	/**
	 * Un-subscribe from list of products buyers
	 * 
	 * @param offer	The remote object of the client
	 * @throws RemoteException If a remote communication error occurs
	 */
	void unsubcribe(final ProductOffer offer) throws RemoteException;
}
