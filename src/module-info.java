/**
 * The RMI module provides support for Remote Method Invocation (RMI) in Java.
 * RMI allows objects in a Java Virtual Machine (JVM) to invoke methods on
 * objects
 * in another JVM, even if those objects are located on a different machine.
 * This module requires the java.rmi module and exports the it.unipr.barbato
 * package
 * to the java.rmi module.
 */
module RMI {
	requires java.rmi;

	exports controller to java.rmi;
	exports Model to java.rmi;
	exports Interface to java.rmi;
}