package it.unipr.barbato.Model.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.unipr.barbato.Model.Interface.ProductOffer;

/**
 * The {@code ProductOfferImpl} represents an implementation of the ProductOffer interface.
 * This class provides methods to set and retrieve information about a product offer.
 * 
 * @author Vincenzo Barbato 345728
 */
public class ProductOfferImpl extends UnicastRemoteObject implements ProductOffer {

	private static final long serialVersionUID = 1L;
	private int sn;
	private int offer;
	private Boolean confirmed;

	/**
	 * Constructor of ProductOfferImpl object.
	 * Initializes confirmed to false, the price and serial number to 0.
	 *
	 * @throws RemoteException If there is a problem with the remote object communication.
	 */
	public ProductOfferImpl() throws RemoteException {
		this.sn = 0;
		this.offer = 0;
		this.confirmed = null;
	}

	/**
	 * Local method to set the offer made by the client.
	 * 
	 * @param offer The client's offer
	 */
	public void setOffer(int offer) {
		this.offer = offer;
	}

	/**
	 * Local method to set the serial number of the product that the client wants.
	 * 
	 * @param sn The serial number of the product
	 */
	public void setSN(int sn) {
		this.sn = sn;
	}

	/**
	 * Local method to get the confirmation status of the offer.
	 * 
	 * @return True if the offer is confirmed, false otherwise
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
