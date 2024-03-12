package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

public class BuyersListImpl extends UnicastRemoteObject implements BuyersList {

	private static final long serialVersionUID = 1L;
	private Set<ProductOffer> offers;
	
	protected BuyersListImpl(Set<ProductOffer> o) throws RemoteException {
		this.offers = o;
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
