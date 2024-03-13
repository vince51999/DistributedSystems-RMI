package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code ProductOffer} interface represents an offer for a product.
 * It provides methods to retrieve the offer, the serial number of the product,
 * and to confirm the client's offer.
 * 
 * @author Vincenzo Barbato 345728
 */
public interface ProductOffer extends Remote {

	/**
	 * Returns the offer for the product.
	 * 
	 * @return The client's offer
	 * @throws RemoteException If a remote communication error occurs
	 */
	int getOffer() throws RemoteException;

	/**
	 * Returns the serial number of the product.
	 * 
	 * @return The serial number of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getSN() throws RemoteException;

	/**
	 * Confirms the client's offer.
	 * 
	 * @param confirmed The server's offer response
	 * @throws RemoteException If a remote communication error occurs
	 */
	void setConfirm(Boolean confirmed) throws RemoteException;
}
