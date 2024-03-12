package it.unipr.barbato;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CallbackServer {
	private static final int PORT = 4200;
	private static final int MIN_PRICE = 10;
	private static final int MAX_PRICE = 200;
	private static final int MIN_CLIENTS = 3;
	
	public CallbackServer() {
	}
	public static void main(String[] args) throws Exception{
		
		Registry registry = LocateRegistry.createRegistry(PORT);
		
		Set<Product> products = productsList(3 * 20);
		ProductsList productsList = new ProductsListImpl(products);
		registry.rebind("productsList", productsList);
		
		Set<ProductOffer> clientList = new CopyOnWriteArraySet<>();	
		BuyersList offersList = new BuyersListImpl(clientList);
		registry.rebind("offersList", offersList);	//publishes a remote reference to that object with external name "subscribe"

		while(clientList.size() < MIN_CLIENTS) {	//the server starts when at least 3 clients are subscribed
			System.out.println("Not enough clients to open the shop: " + clientList.size() + "/" + MIN_CLIENTS);
			Thread.sleep(2000);
		}
	}
	
	private static Set<Product> productsList(int num_product) throws Exception {
		Set<Product> products = new CopyOnWriteArraySet<>();
		for(int i = 0; i < num_product; i++) {
			ProductImpl product = new ProductImpl();
			product.setSN(i);
			product.setPrice(MAX_PRICE, MIN_PRICE);
			products.add(product);
		}
		return products;
	}
	
}
