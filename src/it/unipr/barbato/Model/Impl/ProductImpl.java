package it.unipr.barbato.Model.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import it.unipr.barbato.Model.Interface.Product;

/**
 * The {@code ProductImpl} represents an implementation of the Product
 * interface.
 * This class provides methods to get and set the price and serial number of a
 * product.
 */
public class ProductImpl extends UnicastRemoteObject implements Product {

	private static final long serialVersionUID = 1L;
	private int price;
	private int sn;

	/**
	 * Constructs a new ProductImpl object.
	 * Initializes the price and serial number to 0.
	 *
	 * @throws RemoteException if there is a problem with the remote object
	 *                         communication.
	 */
	public ProductImpl() throws RemoteException {
		this.price = 0;
		this.sn = 0;
	}

	/**
	 * Returns the price of the product.
	 *
	 * @return the price of the product.
	 * @throws RemoteException if there is a problem with the remote object
	 *                         communication.
	 */
	@Override
	public int getPrice() throws RemoteException {
		return this.price;
	}

	/**
	 * Returns the serial number of the product.
	 *
	 * @return the serial number of the product.
	 * @throws RemoteException if there is a problem with the remote object
	 *                         communication.
	 */
	@Override
	public int getSN() throws RemoteException {
		return this.sn;
	}

	/**
	 * Sets the serial number of the product.
	 *
	 * @param sn the serial number of the product.
	 */
	public void setSN(int sn) {
		this.sn = sn;
	}

	/**
	 * Sets the price of the product.
	 *
	 * @param MAX_PRICE the maximum price for the product.
	 * @param MIN_PRICE the minimum price for the product.
	 */
	public void setPrice(int MAX_PRICE, int MIN_PRICE) {
		this.price = new Random().nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
	}

}
