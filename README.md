# SpringBootServices

* A product catalog service which provides the data for a product
* It interacts with 2 microservices inorder to achieve that.
* The first microservice is Product Name Service, which gives the name of the product id
* The second microservice is Product Price service, which gives price data based on the product id
* Product Catalog calls these 2 microservices , collates the data and then send back a response.

# Service Discovery
* Service discovery uses spring cloud eureka technology (Eureka- orginally developed by netflix).
* The discovery server is spring cloud eureka server.
* The 3 microservices are eureka client.
* Client Side service discovery, which means the eureka clients talk to eureka server to find the actual address and then uses that to make calls.
* Here upon calling product catalog service url, product catalog service in order to call the other 2 web services contacts the discovery server to get the actual addresses and make a call.
* Eureka also helps in load balancing, if we have multiple nodes off microservices running and one of them are down, automatically the one which is up is picked up, if both of them are up requests are distributed over the running instance.

# Circuit Breaking
* Uses Hystrix (Originally developed by netflix, comes with spring cloud) for Circuit breaking.
* Uses hystrix to configure the following :
     -- @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000"), --> timeout configuration, which means when a slow responding web service call should timeout. 
		 --	@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"), --> Hystrix checks last 5 request result to take a decision.
		 -- @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"), --> The circuit breaks, if in the last 5 calls, 50% of the calls failed. 
		 -- @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000") --> Every 5 second after circuit breaking the circuit breaker awakes.
* Incase of any error (timeouts, node downtime) there is an automatic fallback response which is configured.
* Hystrix Dashboard , hosted at http://localhost:8080/hystrix/monitor --> monitors the calls. 

# Notes
* The Product Service and the Product Name Service use built in HSQLDB to run operations. The data.sql is included in the respective projects
* Product Service: http://localhost:8080/product/1
* Product Name Service: http://localhost:8082/productname/1
* Product Price Service: http://localhost:8081/productprice/1
* All the microservices uses rest template to communicate with each other.
