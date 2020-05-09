package main.java.com.vinayak.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import main.java.com.vinayak.productservice.model.ProductModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;  


import org.springframework.jdbc.core.RowMapper;  

@Repository
public class ProductModelDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String GET_PRODUCT = "SELECT category, description FROM PRODUCT WHERE id = ?";
	
	public ProductModel getProductDetails(String productId)
	{
		Object[] args = new Object[]{productId};
		
		ProductModel model = null;
		
		List<ProductModel> models = new ArrayList<ProductModel>();
		
		try
		{
			models = jdbcTemplate.query(GET_PRODUCT, args,new RowMapper<ProductModel>()
					{
						@Override
						public ProductModel mapRow(ResultSet rs, int rownumber) throws SQLException 
						{
							ProductModel model = new ProductModel();
							model.setCategory(rs.getString("category"));
							model.setDescription(rs.getString("description"));
							
							return model;
						}
					});
		}
		catch(Exception ex)
		{
			
		}
		
		return models.get(0);
	}

}
