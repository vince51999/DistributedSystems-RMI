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
		
		Set<ProductOffer> offers = new CopyOnWriteArraySet<>();	
		BuyersList offersList = new BuyersListImpl(offers);
		registry.rebind("offersList", offersList);	//publishes a remote reference to that object with external name "subscribe"

		while(offers.size() < MIN_CLIENTS) {	//the server starts when at least 3 clients are subscribed
			System.out.println("Wait clients: " + offers.size() + "/" + MIN_CLIENTS);
			Thread.sleep(2000);
		}
		
		while(offers.size() > 0) {
			for(Product product : products) {
				((ProductImpl) product).setPrice(MAX_PRICE, MIN_PRICE);
				System.out.println("--------------------");
				System.out.println("SN: " + product.getSN() + " Price: " + product.getPrice()+ "$");
			}
			try {	
				Thread.sleep(2000);
				for(ProductOffer offer: offers) {
					int sn = offer.getSN();
					int o = offer.getOffer();
					if(o > 0 && sn > 0) {
						Product p = productsList.getProduct(sn);
						
						System.out.println("--------------------");
						System.out.println("SN: " + sn + " Price: " + p.getPrice()+ "$" + " Offer: " + o + "$");
						if(p.getPrice() <= o) {
							offer.setConfirm(true);
							System.out.println("Offer accepted");
						}else {
							offer.setConfirm(false);
							System.out.println("Offer rejected");
						}
					}
					Thread.sleep(300);
				}
				
			}
			catch(Exception e) {
				continue;
			}
		}
	}
	/**
	 * Create a list of product with price between (MAX_PRICE, MIN_PRICE) and SN between (1, num_product)
	 * @param num_products number of products
	 * @return list of products
	 * @throws Exception
	 */
	private static Set<Product> productsList(int num_products) throws Exception {
		Set<Product> products = new CopyOnWriteArraySet<>();
		for(int i = 0; i < num_products; i++) {
			ProductImpl product = new ProductImpl();
			product.setSN(i + 1);
			product.setPrice(MAX_PRICE, MIN_PRICE);
			products.add(product);
		}
		return products;
	}
	
}
