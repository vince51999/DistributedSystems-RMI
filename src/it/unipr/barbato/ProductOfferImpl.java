package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductOfferImpl extends UnicastRemoteObject implements ProductOffer  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sn;
	private int offer;
	private Boolean confirmed;

	protected ProductOfferImpl() throws RemoteException {
		this.sn = 0;
		this.offer = 0;
		this.confirmed = null;
	}
	
	@Override
	public void setOffer(int o) throws RemoteException {
		this.offer = o;
	}
	
	@Override
	public void setSN(int sn) throws RemoteException {
		this.sn = sn;
	}
	
	@Override
	public Boolean getConfirm() throws RemoteException {
		return this.confirmed;
	}
	
	/**
	 * Set if offer is confirmed or not
	 * @param confirmed
	 */
	public void setConfirm(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * Return offer for product
	 * @return client offer
	 * @throws RemoteException
	 */
	public int getOffer()  {
		return this.offer;
	}

	/**
	 * Return sn for product
	 * @return sn of product
	 * @throws RemoteException
	 */
	public int getSN() throws RemoteException {
		return this.sn;
	}
	
}
