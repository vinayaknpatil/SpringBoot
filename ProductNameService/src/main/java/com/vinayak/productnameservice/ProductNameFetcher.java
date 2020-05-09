package com.vinayak.productnameservice;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductNameFetcher {

	@Autowired
	ProductDao productDao;
	
	public String getProductName(String productId)
	{
		return productDao.getProductName(productId);
		
	}
	
}
