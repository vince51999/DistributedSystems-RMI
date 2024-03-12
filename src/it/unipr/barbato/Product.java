package it.unipr.barbato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote{
	/**
	 * Return prize of product
	 * @return current prize of product
	 * @throws RemoteException
	 */
	int getPrice() throws RemoteException;
	/**
	 * Return SN of product
	 * @return Serial number of product 
	 * @throws RemoteException
	 */
	int getSN() throws RemoteException;
}
