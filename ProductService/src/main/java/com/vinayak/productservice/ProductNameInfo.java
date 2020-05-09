package main.java.com.vinayak.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductNameInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getProductName(String productId)
	{
		return restTemplate.getForObject("http://ProductNameService/productname/"+productId,String.class);
		
	}

}
