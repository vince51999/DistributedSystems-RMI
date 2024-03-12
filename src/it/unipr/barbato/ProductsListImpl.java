package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

public class ProductsListImpl extends UnicastRemoteObject implements ProductsList{
    
	private static final long serialVersionUID = 1L;
	private Set<Product> products;
	
	public ProductsListImpl(final Set<Product> p) throws RemoteException {
		this.products = p;
	}

	@Override
	public Product getProduct(int sn) throws RemoteException {
		for(Product p : this.products) {
			if(p.getSN() == sn) {
				return p;
			}
		}
		return new ProductImpl();
	public Set<Product> getProducts() throws RemoteException {
		return this.products;
	}

	@Override
	public int size() throws RemoteException {
		return this.products.size();
	}

	@Override
		}
		return tmp;
	}



}
