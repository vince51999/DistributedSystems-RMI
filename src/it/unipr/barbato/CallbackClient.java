package it.unipr.barbato;

public class CallbackClient {

	public static int getRandomSN(ArrayList<Integer> array) {
	    int rnd = new Random().nextInt(array.size());
	    return array.get(rnd);
	}
	public static int getRandomOffer() {
	    return new Random().nextInt(MAX_PRICE - MIN_PRICE) + MIN_PRICE;
	}
}
