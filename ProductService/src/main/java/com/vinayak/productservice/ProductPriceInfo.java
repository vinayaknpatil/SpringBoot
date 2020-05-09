package main.java.com.vinayak.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ProductPriceInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod ="getFallbackProdPrice",
			commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					 @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
					 @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
					 @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000")
					 })
	public Integer getProductPrice(String productId)
	{
		return restTemplate.getForObject("http://ProductPriceService/productprice/"+productId,Integer.class);
		
	}
	
	public Integer getFallbackProdPrice(String productId)
	{
		return -1;
	}

}
