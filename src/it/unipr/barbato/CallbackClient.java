package it.unipr.barbato;

public class CallbackClient {

	public static int getRandomSN(ArrayList<Integer> array) {
	    int rnd = new Random().nextInt(array.size());
	    return array.get(rnd);
	}
}
