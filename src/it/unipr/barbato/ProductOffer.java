package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductOffer extends Remote{

	/**
	 * Return offer for product
	 * @return client offer
	 * @throws RemoteException
	 */
	int getOffer() throws RemoteException;
	
	/**
	 * Return SN of product
	 * @return serial number of the product
	 * @throws RemoteException
	 */
	int getSN() throws RemoteException;

	/**
	 * This method is used to confirm client offer
	 * @param Server offer response
	 * @throws RemoteException
	 */
	void setConfirm(Boolean confirmed) throws RemoteException;
}
