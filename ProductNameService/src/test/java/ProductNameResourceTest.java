import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

import com.vinayak.productnameservice.ProductNameFetcher;
import com.vinayak.productnameservice.ProductNameResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProductNameResource.class})
@WebAppConfiguration
public class ProductNameResourceTest {
	
	@InjectMocks
	ProductNameResource prodNameResource;
	
	@Mock
	ProductNameFetcher prodNameFetcher;
	
	@Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void whenProductIdIsAvailable()
	{
		String productId = "133";
		String name = "My prod";
		
		Mockito.when(prodNameResource.getName(productId)).thenReturn(name);
		
		String actual = prodNameResource.getName(productId);
		
		assertEquals(name, actual);
	}
	
	
	
}
