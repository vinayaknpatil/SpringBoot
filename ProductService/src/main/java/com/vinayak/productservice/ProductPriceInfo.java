package main.java.com.vinayak.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductPriceInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Integer getProductPrice(String productId)
	{
		return restTemplate.getForObject("http://ProductPriceService/productprice/"+productId,Integer.class);
		
	}

}
