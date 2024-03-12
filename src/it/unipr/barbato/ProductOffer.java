package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductOffer extends Remote{
	/**
	 * Set client offer
	 * @param o Client offer
	 */
	void setOffer(int o) throws RemoteException;
	
	/**
	 * Set SN of product that client want
	 * @param sn Serial number of product
	 */
	void setSN(int sn) throws RemoteException;

	/**
	 * Return server offer confirm
	 * Return offer confirm
	 * @return Server confirm
	 * @throws RemoteException
	 */
	Boolean getConfirm() throws RemoteException;
}
