package mylab.order.di.xml;

public class OrderSpringTest {
    public static void main(String[] args) {
        // Load the Spring context from XML configuration
        org.springframework.context.ApplicationContext context =
            new org.springframework.context.support.ClassPathXmlApplicationContext("../resources/mylab-order-di.xml");

        // Retrieve the OrderService bean
        OrderService orderService = context.getBean(OrderService.class);

        // Print the shopping cart and total price
        System.out.println("Shopping Cart: " + orderService.getShoppingCart());
        System.out.println("Total Price: " + orderService.calculateOrderTotal());
    }
}
