package com.vinayak.productpriceservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productprice")
public class ProductPriceResource {
	
	
	@RequestMapping("/{id}")
	public Double getPrice(@PathVariable("id") String productId)
	{
		return new Double("10.34");
		
	}

}
