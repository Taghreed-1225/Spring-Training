import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ProductTest {
    RestTemplate restTemplate=new RestTemplate();

    @Test
    public void testFindById (){


        String url ="http://localhost:8080/SpringMvcCrudApp/products?productId=4";
        ResponseEntity< Product > response=restTemplate.getForEntity(url, Product.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    public void testInsertionProduct () throws ParseException {


        String url ="http://localhost:8080/SpringMvcCrudApp/products";

        ProductDetails productDetails=new ProductDetails("Tea",15,true,"el3rosa",new Date(2024-12-12));
       ProductDetails response=restTemplate.postForObject(url, productDetails,ProductDetails.class);
        System.out.println(response);
    }
}
