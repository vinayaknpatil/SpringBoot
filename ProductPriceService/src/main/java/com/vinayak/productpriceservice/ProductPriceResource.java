package com.vinayak.productpriceservice;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productprice")
public class ProductPriceResource {
	
	private Map<String, Integer> priceMap = new HashMap<>();
	private Random random =  new Random();
	
	@RequestMapping("/{id}")
	public Integer getPrice(@PathVariable("id") String productId)
	{
		if(!priceMap.containsKey(productId))
		{
			Integer price = random.nextInt(1000);
			priceMap.put(productId, price);
		}
		return priceMap.get(productId);
		
	}

}
