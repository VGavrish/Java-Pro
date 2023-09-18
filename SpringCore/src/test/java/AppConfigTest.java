import org.example.HomeWork31.AppConfig;
import org.example.HomeWork31.Cart;
import org.example.HomeWork31.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AppConfig.class)
public class AppConfigTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cart cart;

    @Test
    public void testProductRepositoryBeanCreation() {
        assertNotNull(productRepository);
    }

    @Test
    public void testCartBeanCreation() {
        assertNotNull(cart);
    }
}
