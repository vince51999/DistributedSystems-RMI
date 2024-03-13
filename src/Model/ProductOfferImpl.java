package Model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.ProductOffer;

/**
 * The {@code ProductOfferImpl} represents an implementation of the ProductOffer
 * interface.
 * This class provides methods to set and retrieve information about a product
 * offer.
 */
public class ProductOfferImpl extends UnicastRemoteObject implements ProductOffer {

	private static final long serialVersionUID = 1L;
	private int sn;
	private int offer;
	private Boolean confirmed;

	public ProductOfferImpl() throws RemoteException {
		this.sn = 0;
		this.offer = 0;
		this.confirmed = null;
	}

	/**
	 * Local method to set the offer made by the client.
	 * 
	 * @param o The client's offer
	 */
	public void setOffer(int o) {
		this.offer = o;
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
