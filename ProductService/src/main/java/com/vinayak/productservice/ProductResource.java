package main.java.com.vinayak.productservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import main.java.com.vinayak.productservice.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductNameInfo prodNameInfo;
	
	@Autowired
	private ProductPriceInfo prodPriceInfo;
	
	@Autowired
	private ProductFetcher productFetcher;
	
	@RequestMapping("/{id}")
	public ResponseEntity<ProductModel> getProductData(@PathVariable("id") String productId)
	{
		
		String productName = prodNameInfo.getProductName(productId);
		Integer productPrice = prodPriceInfo.getProductPrice(productId);
		
		ProductModel model = productFetcher.getProductModel(productId);
		if(model == null) // Return empty model
		{
			return new ResponseEntity(new ProductModel(), HttpStatus.BAD_REQUEST);
		}
		model.setProductName(productName);
		model.setPrice(productPrice);
		
		return new ResponseEntity(model,HttpStatus.OK);
		
	}

}
