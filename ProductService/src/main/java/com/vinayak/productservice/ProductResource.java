package main.java.com.vinayak.productservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductNameInfo prodNameInfo;
	
	@Autowired
	private ProductPriceInfo prodPriceInfo;
	
	@RequestMapping("/{id}")
	public String getProductData(@PathVariable("id") String productId)
	{
		
		String productName = prodNameInfo.getProductName(productId);
		
		Double productPrice = prodPriceInfo.getProductPrice(productId);
		
		return productName + " --- "+ productPrice;
		
	}

}
