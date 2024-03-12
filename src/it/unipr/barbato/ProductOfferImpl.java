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
	
	/**
	 * Local method to set offer
	 * @param o Client offer
	 */
	public void setOffer(int o) {
		this.offer = o;
	}
	
	/**
	 * Local method to set SN of product that client want
	 * @param sn Serial number of product
	 */
	public void setSN(int sn) {
		this.sn = sn;
	}
	
	/**
	 * Local method to get offer confirm
	 * @return True if offer is confirmed, false otherwise
	 */
	public Boolean getConfirm() {
		return this.confirmed;
	}

	@Override
	public int getOffer() throws RemoteException {
		return this.offer;
	}

	@Override
	public void setConfirm(Boolean confirmed) throws RemoteException {
		this.confirmed = confirmed;
	}

	@Override
	public int getSN() throws RemoteException {
		return this.sn;
	}
	
}
