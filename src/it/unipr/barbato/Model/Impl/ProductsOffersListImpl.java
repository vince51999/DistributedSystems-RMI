package it.unipr.barbato.Model.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import it.unipr.barbato.Model.Interface.ProductOffer;
import it.unipr.barbato.Model.Interface.ProductsOffersList;

public class ProductsOffersListImpl extends UnicastRemoteObject implements ProductsOffersList {
	
	private static final long serialVersionUID = 1L;
	private Set<ProductOffer> offers;
	
	/**
	 * Constructor of BuyersListImpl
	 * @param offers List of client offers
	 * @throws RemoteException
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
