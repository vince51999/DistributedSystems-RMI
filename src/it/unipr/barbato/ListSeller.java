package it.unipr.barbato;

import java.rmi.Remote;

/**
 * The {@code ListSeller} interface represents a seller that can be followed.
 * It extends the Remote interface to support remote method invocation (RMI).
 */
public interface ListSeller extends Remote {
	/**
	 * Allows a client to follow the seller.
	 */
	void followSeller();
}
