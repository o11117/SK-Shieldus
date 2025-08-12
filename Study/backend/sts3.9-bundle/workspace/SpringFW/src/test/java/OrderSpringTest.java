import mylab.order.di.xml.OrderService;
import mylab.order.di.xml.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    @Qualifier("orderService")
    OrderService orderService;

    @Autowired
    @Qualifier("shoppingCart")
    ShoppingCart shoppingCart;

    @Test
    void shoppingCartBeanTest() {
        assertNotNull(shoppingCart);
        assertNotNull(shoppingCart.getProducts());
        System.out.println("개수: " + shoppingCart.getProducts().size());
        assertEquals(2, shoppingCart.getProducts().size());
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    @Test
    void orderServiceBeanTest() {
        assertNotNull(orderService);
        assertNotNull(orderService.getShoppingCart());
        assertEquals(2, orderService.getShoppingCart().getProducts().size());
        assertEquals("노트북", orderService.getShoppingCart().getProducts().get(0).getName());
        assertEquals("스마트폰", orderService.getShoppingCart().getProducts().get(1).getName());
    }
}
