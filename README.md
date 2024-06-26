﻿# DistributedSystems-RMI

**Author:** Vincenzo Barbato
**Date:** 03/2024

This project simulates a distributed shop application based on RMI module provides support for Remote Method Invocation (RMI) in Java.

## Documentation 

Javadoc documentation can be found in the folder:  **RMI/javadoc**
To view the project documentation on the open browser click on: **index.html**

## Setup environment

To run ***.jar** files you needJDK Development Kit 21.

To manage project you need JavaIDE (we use eclipse with javaSE-17).

The project use port **1099** therefore is necessary keep free it or change it.

## Run application with *.jar files

This is a simulation of distributed shop application based on 1 server and 3 clients.

First one we need to open 4 terminal in the folder where there are ***.jar** files.

In the first terminal we run the server:
```
java -jar RMIServer.jar
```
In the others 3 terminal we run the clients:
```
java -jar RMIClient.jar
```
