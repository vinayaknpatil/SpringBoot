package main.java.com.vinayak.productservice;
import org.springframework.stereotype.Service;

import main.java.com.vinayak.productservice.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductFetcher {

	@Autowired
	ProductModelDao productModelDao;
	
	public ProductModel getProductModel(String productId)
	{
		return productModelDao.getProductDetails(productId);
		
	}
	
}
