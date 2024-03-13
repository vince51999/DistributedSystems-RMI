package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code OffersList} interface represents the list of client offers.
 * It provides methods to subscribe and un-subscribe from the 
 * and to confirm the client's offer.
 */
public interface ProductsOffersList extends Remote{
	/**
	 * Subscribe to list of products buyers
	 * 
	 * @param offer	The remote object of the client
	 * @throws RemoteException
	 */
	void subscribe(final ProductOffer offer) throws RemoteException;
	
	/**
	 * Un-subscribe from list of products buyers
	 * 
	 * @param offer	The remote object of the client
	 * @throws RemoteException
	 */
	void unsubcribe(final ProductOffer offer) throws RemoteException;
}
