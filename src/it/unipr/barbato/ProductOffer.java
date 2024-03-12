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
	 * Return offer confirm
	 * @return Server confirm
	 * @throws RemoteException
	 */
	Boolean getConfirm() throws RemoteException;
}
