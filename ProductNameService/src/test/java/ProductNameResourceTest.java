import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vinayak.productnameservice.ProductNameResource;

@WebAppConfiguration
@ContextConfiguration(classes={ProductNameResource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductNameResourceTest {

	@Mock
	ProductNameResource prodNameResource = Mockito.mock(ProductNameResource.class);
	@Test
	public void whenProductIdIsAvailable()
	{
		
		String productId = "123";
		String name = "My product";
		
		Mockito.when(prodNameResource.getName(productId)).thenReturn(name);
		
		String res = prodNameResource.getName(productId);
		assertEquals(res, name);
	
	}
	
}
