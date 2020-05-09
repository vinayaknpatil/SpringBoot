package com.vinayak.productnameservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productname")
public class ProductNameResource {
	
	
	@RequestMapping("/{id}")
	public String getName(@PathVariable("id") String productId)
	{
		return "Mac Laptop";
		
	}

}
