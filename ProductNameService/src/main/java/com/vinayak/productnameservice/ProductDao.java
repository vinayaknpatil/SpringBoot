package com.vinayak.productnameservice;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String NOT_FOUND = "NOT_FOUND";
	
	public String getProductName(String productId)
	{
		
		String query = "SELECT product_name FROM PRODUCT_NAME WHERE id = ?";
		
		System.out.println("Product id "+productId);
		
		Object[] args = new Object[]{new Long(productId)};
		
		String productName = "";
		
		try
		{
			productName = jdbcTemplate.queryForObject(query,args, String.class);
		}
		catch(Exception ex)
		{
			
			productName = NOT_FOUND;
			
		}
		
		System.out.println("Name for id "+productId+" is "+productName);
		
		return productName;
	}
	
}
