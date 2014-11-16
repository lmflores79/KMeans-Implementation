KMeans-Implementation
=====================

This is a simple implementation of the KMeans clustering algorithm in JAVA. 

Altough it is just for academic purposes and is the main reason of this little project, it shows also some basic usage of the 
following:

* Basic usage of Spring IoC container using just dependency injection feature for managing beans.
* Code coverage through JUnit using a mocking approach through EasyMock
* Implementation of a sample integration test using either a standard failsafe maven plugin approach or a 
  JUnit category annotation approach


The project was done on Eclipse Indigo. To import it just clone the repository and on Eclipse, select Import / Existing Maven Projects

The project has a Main class in the default package which shows how to invoke the KMeans service implemented.
There is a file in the folder src/test/resources named Iris_Sin.csv for you to play with. Also, there is a file called KMeans-example.xls 
which has an example of an applied kmeans algorithm to a set of patterns. The information contained in this spreadsheet is the base of the unit tests. 
Please refer to it when looking at the unit testing classes.
