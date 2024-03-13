package it.unipr.barbato.Controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

import it.unipr.barbato.Model.Impl.ProductOfferImpl;
import it.unipr.barbato.Model.Interface.ProductOffer;
import it.unipr.barbato.Model.Interface.ProductsList;
import it.unipr.barbato.Model.Interface.ProductsOffersList;

/**
 * The {@code CallbackClient} class represents a client that interacts with a
 * remote server using RMI (Remote Method Invocation).
 * It subscribes to the offers list and purchases products from the products
 * list.
 * Each client creates a remote object that will be used by the server
 * to retrieve possible offers for the products.
 * 
 * A client keeps running until it completes a certain number of purchases
 * (10 is default).
 * 
 * The client periodically retrieves the current price of the product and it
 * randomly generates a maximum purchase price; if the product price is less
 * than this value, the client makes an offer to the server. If the client
 * has made an offer it waits until it receives the outcome (either accepted or
 * rejected).
 * 
 *
 */
public class CallbackClient {
	private static final int MIN_PRICE = 10;
	private static final int MAX_PRICE = 200;
	private static final int PURCHASES = 10;

	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry();

		ProductOffer myOffer = new ProductOfferImpl();

		ProductsList productsList = (ProductsList) registry.lookup("productsList");

		ProductsOffersList offersList = (ProductsOffersList) registry.lookup("offersList");
		offersList.subscribe(myOffer);

		int productsCount = 0;
		while (productsCount < PURCHASES) {
			ArrayList<Integer> sns = productsList.getSNs();
			if (sns.size() > 0) {
				int sn = getRandomSN(sns);
				int offer = getRandomOffer();
				int price = productsList.getProduct(sn).getPrice();
				((ProductOfferImpl) myOffer).setSN(sn);
				((ProductOfferImpl) myOffer).setOffer(offer);
				System.out.println("-------------------------");
				System.out.println("SN: " + sn + " Price: " + price + " Offer: " + offer);

				Boolean confirm = null;
				while (confirm == null) {
					Thread.sleep(1000);
					confirm = ((ProductOfferImpl) myOffer).getConfirm();
				}
				System.out.println("-------------------------");
				if (confirm) {
					productsCount++;
					System.out.println("Server has accepted offer! Product with sn: " + sn
							+ " has been bought at price: " + offer + "$");
				} else {
					System.out.println(
							"Server has rejected the offered price: " + offer + "$ " + " for product with sn: " + sn);
				}

				myOffer.setConfirm(null);
				((ProductOfferImpl) myOffer).setOffer(0);
				((ProductOfferImpl) myOffer).setSN(0);
			}
			System.out.println(productsCount + "/" + PURCHASES);
			Thread.sleep(2000);

		}
		System.out.println("Leave the shop.");
		offersList.unsubcribe(myOffer);
		UnicastRemoteObject.unexportObject(myOffer, false);
	}

	public static int getRandomSN(ArrayList<Integer> array) {
		int rnd = new Random().nextInt(array.size());
		return array.get(rnd);
	}

	public static int getRandomOffer() {
		return new Random().nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
	}
}
