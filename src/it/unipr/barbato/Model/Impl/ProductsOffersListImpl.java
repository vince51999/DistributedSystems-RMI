package it.unipr.barbato.Model.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import it.unipr.barbato.Model.Interface.ProductOffer;
import it.unipr.barbato.Model.Interface.ProductsOffersList;

/**
 * The {@code ProductsOffersListImpl} is an implementation class for the ProductsOffersList interface.
 * This class provides methods to initialize the list of clients offers and subscribe/un-subscribe to it.
 * 
 * @author Vincenzo Barbato 345728
 */
public class ProductsOffersListImpl extends UnicastRemoteObject implements ProductsOffersList {
	
	private static final long serialVersionUID = 1L;
	private Set<ProductOffer> offers;
	
	/**
	 * Constructor of ProductsOffersListImpl object.
	 * 
	 * @param offers List of client offers
	 * @throws RemoteException If a remote communication error occurs
	 */
	public ProductsOffersListImpl(Set<ProductOffer> offers) throws RemoteException {
		this.offers = offers;
	}

	@Override
	public void subscribe(ProductOffer o) throws RemoteException {
		this.offers.add(o);
	}

	@Override
	public void unsubcribe(ProductOffer o) throws RemoteException {
		this.offers.remove(o);
	}

}
