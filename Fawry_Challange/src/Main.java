import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 10.0, 5, true,
                LocalDate.now().minusDays(1), true, 0.5);
        Product biscuits = new Product("Biscuits", 5.0, 10, true,
                LocalDate.now().plusDays(30), true, 0.3);
        Product tv = new Product("TV", 500.0, 2, false, null, true, 10.0);
        Product mobileCard = new Product("Mobile Scratch Card", 20.0, 100,
                false, null, false, 0.0);


        Customer customer = new Customer(1000.0);
        ShippingService shippingService = new ShippingService();

        // Test case 1: Normal checkout
        System.out.println("Test Case 1: Normal checkout");
        customer.addToCart(biscuits, 2);
        customer.addToCart(tv, 1);
        customer.checkout(shippingService);

        // test case 2: Empty cart
        System.out.println("\nTest Case 2: Empty cart");
        customer.checkout(shippingService);

        // test case 3: Expired product
        System.out.println("\nTest Case 3: Expired product");
        customer.addToCart(cheese, 1);
        customer.checkout(shippingService);

        // test case 4: Insufficient quantity
        System.out.println("\nTest Case 4: Insufficient quantity");
        customer.addToCart(biscuits, 20);
        customer.checkout(shippingService);

        // test case 5: Insufficient balance
        System.out.println("\nTest Case 5: Insufficient balance");
        Customer poorCustomer = new Customer(10.0);
        poorCustomer.addToCart(tv, 1);
        poorCustomer.checkout(shippingService);

    }
}