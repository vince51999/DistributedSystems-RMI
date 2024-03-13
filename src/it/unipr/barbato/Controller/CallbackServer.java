package it.unipr.barbato.Controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import it.unipr.barbato.Model.Impl.ProductImpl;
import it.unipr.barbato.Model.Impl.ProductsListImpl;
import it.unipr.barbato.Model.Impl.ProductsOffersListImpl;
import it.unipr.barbato.Model.Interface.Product;
import it.unipr.barbato.Model.Interface.ProductOffer;
import it.unipr.barbato.Model.Interface.ProductsList;
import it.unipr.barbato.Model.Interface.ProductsOffersList;

/**
 * The {@code CallbackServer} class defines the behavior of the remote server.
 * The server starts selling its product only when at least 3 clients have
 * subscribed.
 * It keeps running until all the clients have completed their purchases.
 * The server periodically updated the prices of all products in the remote list.
 * Then it checks, for each client, the offer for a specific SN and confirm the offer if is more high than product price,
 * otherwise reject client offer.
 * 
 * @author Vincenzo Barbato 345728
 */
public class CallbackServer {
	/**
	 * Port for distributed application
	 */
	private static final int PORT = 1099;
	/**
	 * Min price for product
	 */
	private static final int MIN_PRICE = 10;
	/**
	 * Max price for product
	 */
	private static final int MAX_PRICE = 200;
	
	/**
	 * Min number of clients to open the shop
	 */
	private static final int MIN_CLIENTS = 3;

	/**
	 * Constructor of CallbackServer
	 */
	public CallbackServer() {
	}

	/**
	 * Runnable method to run server
	 * @param args Arguments for main method
	 * @throws Exception If there is a problem
	 */
	public static void main(String[] args) throws Exception {

		Registry registry = LocateRegistry.createRegistry(PORT);
		
		// Create list of products
		Set<Product> products = productsList(3 * 10);
		ProductsList productsList = new ProductsListImpl(products);
		registry.rebind("productsList", productsList);

		// Create list of clients offers
		Set<ProductOffer> offers = new CopyOnWriteArraySet<>();
		ProductsOffersList offersList = new ProductsOffersListImpl(offers);
		registry.rebind("offersList", offersList);
		
		// Wait clients
		while (offers.size() < MIN_CLIENTS) {
			System.out.println("Wait clients: " + offers.size() + "/" + MIN_CLIENTS);
			Thread.sleep(2000);
		}

		// There are clients that want buy
		while (offers.size() > 0) {
			for (Product product : products) {
				((ProductImpl) product).setPrice(MAX_PRICE, MIN_PRICE);
				System.out.println("--------------------");
				System.out.println("SN: " + product.getSN() + " Price: " + product.getPrice() + "$");
			}
			try {
				Thread.sleep(2000);
				// For each client check offer
				for (ProductOffer offer : offers) {
					int sn = offer.getSN();
					int o = offer.getOffer();
					if (o > 0 && sn > 0) {
						Product p = productsList.getProduct(sn);

						System.out.println("--------------------");
						System.out.println("SN: " + sn + " Price: " + p.getPrice() + "$" + " Offer: " + o + "$");
						if (p.getPrice() <= o) {
							offer.setConfirm(true);
							System.out.println("Offer accepted");
						} else {
							offer.setConfirm(false);
							System.out.println("Offer rejected");
						}
					}
					Thread.sleep(300);
				}
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println("All clients are disconnected. Shop close.");
		UnicastRemoteObject.unexportObject(productsList, false);
		UnicastRemoteObject.unexportObject(offersList, false);
	}

	/**
	 * Create a list of products with prices between (MAX_PRICE, MIN_PRICE) and SN
	 * between (1, num_product)
	 * 
	 * @param num_products Number of products
	 * @return List of products
	 * @throws Exception If there is a problem
	 */
	private static Set<Product> productsList(int num_products) throws Exception {
		Set<Product> products = new CopyOnWriteArraySet<>();
		for (int i = 0; i < num_products; i++) {
			ProductImpl product = new ProductImpl();
			product.setSN(i + 1);
			product.setPrice(MAX_PRICE, MIN_PRICE);
			products.add(product);
		}
		return products;
	}

}
