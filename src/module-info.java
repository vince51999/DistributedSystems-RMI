/**
 * The RMI module provides support for Remote Method Invocation (RMI) in Java.
 * RMI allows objects in a Java Virtual Machine (JVM) to invoke methods on
 * objects in another JVM, even if those objects are located on a different machine.
 * This module requires the java.rmi module and exports the it.unipr.barbato
 * package to the java.rmi module.
 * 
 * @author Vincenzo Barbato 345728
 */
module RMI {
	requires java.rmi;

	exports it.unipr.barbato.Controller to java.rmi;
	exports it.unipr.barbato.Model.Impl to java.rmi;
	exports it.unipr.barbato.Model.Interface to java.rmi;
}