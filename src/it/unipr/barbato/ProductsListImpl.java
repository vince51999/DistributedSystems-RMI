package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

/**
 * The {@code ProductsListImpl} is an implementation class for the ProductsList
 * interface.
 * This class provides methods to retrieve products and their serial numbers.
 */
public class ProductsListImpl extends UnicastRemoteObject implements ProductsList {

	private static final long serialVersionUID = 1L;
	private Set<Product> products;

	/**
	 * Constructs a ProductsListImpl object with the specified set of products.
	 * 
	 * @param p the set of products
	 * @throws RemoteException if a remote communication error occurs
	 */
	public ProductsListImpl(final Set<Product> p) throws RemoteException {
		this.products = p;
	}

	/**
	 * Retrieves the product with the specified serial number.
	 * 
	 * @param sn the serial number of the product
	 * @return the product with the specified serial number, or a new ProductImpl
	 *         object if no product is found
	 * @throws RemoteException if a remote communication error occurs
	 */
	@Override
	public Product getProduct(int sn) throws RemoteException {
		for (Product p : this.products) {
			if (p.getSN() == sn) {
				return p;
			}
		}
		return new ProductImpl();
	}

	/**
	 * Retrieves the list of serial numbers of all products.
	 * 
	 * @return the list of serial numbers of all products
	 * @throws RemoteException if a remote communication error occurs
	 */
	@Override
	public ArrayList<Integer> getSNs() throws RemoteException {
		ArrayList<Integer> sns = new ArrayList<>();

		System.out.println(this.products.size());
		for (Product p : this.products) {
			sns.add(p.getSN());
		}
		return sns;
	}
}
