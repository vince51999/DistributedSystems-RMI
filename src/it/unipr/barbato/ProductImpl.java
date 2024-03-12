package it.unipr.barbato;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ProductImpl extends UnicastRemoteObject implements Product {

	private static final long serialVersionUID = 1L;
	private int price;
	private int sn;

	public ProductImpl() throws RemoteException {
		this.price = 0;
		this.sn = 0;
	}

	@Override
	public int getPrice() throws RemoteException {
		return this.price;
	}

	@Override
	public int getSN() throws RemoteException {
		return this.sn;
	}
	/**
	 * Local method to set SN of product
	 * @param sn Serial number of product
	 */
	public void setSN(int sn) {
		this.sn = sn;
	}
	/**
	 * Local method to set price of product
	 * @param MAX_PRICE Max price for product
	 * @param MIN_PRICE Min price for product
	 */
	public void setPrice(int MAX_PRICE, int MIN_PRICE) {
		Random random = new Random();
		int price = random.nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
		this.price = price;
	}

}
