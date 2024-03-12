package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;

public class ProductsListImpl extends UnicastRemoteObject implements ProductsList{
    
	private static final long serialVersionUID = 1L;
	private Set<Product> products;
	
	public ProductsListImpl(final Set<Product> p) throws RemoteException {
		this.products = p;
	}

	@Override
	public Set<Product> getProducts() throws RemoteException {
		return this.products;
	}

	@Override
	public int size() throws RemoteException {
		return this.products.size();
	}

	@Override
	public Product getProduct(int index) throws RemoteException {
		Iterator<Product> it = this.products.iterator();
		Product tmp = null;
		for(int i = 0; i <= index; i++) {
			tmp = it.next();
		}
		return tmp;
	}



}
