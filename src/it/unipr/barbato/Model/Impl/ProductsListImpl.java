package it.unipr.barbato.Model.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

import it.unipr.barbato.Model.Interface.Product;
import it.unipr.barbato.Model.Interface.ProductsList;

/**
 * The {@code ProductsListImpl} is an implementation class for the ProductsList interface.
 * This class provides methods to retrieve products and their serial numbers.
 * 
 * @author Vincenzo Barbato 345728
 */
public class ProductsListImpl extends UnicastRemoteObject implements ProductsList {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * List of products available
	 */
	private Set<Product> products;

	/**
	 * Constructor of ProductsListImpl object
	 * Initializes the products with the specified set of products
	 * 
	 * @param p The set of products
	 * @throws RemoteException If a remote communication error occurs
	 */
	public ProductsListImpl(final Set<Product> p) throws RemoteException {
		this.products = p;
	}

	@Override
	public Product getProduct(int sn) throws RemoteException {
		for (Product p : this.products) {
			if (p.getSN() == sn) {
				return p;
			}
		}
		return new ProductImpl();
	}

	@Override
	public ArrayList<Integer> getSNs() throws RemoteException {
		ArrayList<Integer> sns = new ArrayList<>();

		for (Product p : this.products) {
			sns.add(p.getSN());
		}
		return sns;
	}
}
