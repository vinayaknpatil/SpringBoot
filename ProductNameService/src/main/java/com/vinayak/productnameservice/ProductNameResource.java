package com.vinayak.productnameservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/productname")
public class ProductNameResource {
	
	
	@Autowired
	ProductNameFetcher prodNameFetcher;
	
	
	@RequestMapping("/{id}")
	public String getName(@PathVariable("id") String productId)
	{
		return prodNameFetcher.getProductName(productId);
		
	}

}
