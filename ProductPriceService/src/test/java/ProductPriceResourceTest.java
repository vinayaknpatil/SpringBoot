
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vinayak.productpriceservice.ProductPriceResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProductPriceResource.class})
@WebAppConfiguration
public class ProductPriceResourceTest {

	@Mock
	private ProductPriceResource productPriceResource;
		
	@Test
	public void whenProductIdIsAvailable()
	{
		String productId = "123";
		Integer price = 100;
		
		Mockito.when(productPriceResource.getPrice(productId)).thenReturn(price);
		
		Integer res = productPriceResource.getPrice(productId);
		assertEquals(res, price);
	
	}
	
	
	
}
