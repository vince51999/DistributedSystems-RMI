package it.unipr.barbato.Model.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The {@code ProductOffer} interface represents an offer for a product.
 * It provides methods to retrieve the offer, the serial number of the product,
 * and to confirm the client's offer.
 */
public interface ProductOffer extends Remote {

	/**
	 * Returns the offer for the product.
	 * 
	 * @return the client's offer
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getOffer() throws RemoteException;

	/**
	 * Returns the serial number of the product.
	 * 
	 * @return the serial number of the product
	 * @throws RemoteException if a remote communication error occurs
	 */
	int getSN() throws RemoteException;

	/**
	 * Confirms the client's offer.
	 * 
	 * @param confirmed the server's offer response
	 * @throws RemoteException if a remote communication error occurs
	 */
	void setConfirm(Boolean confirmed) throws RemoteException;
}
