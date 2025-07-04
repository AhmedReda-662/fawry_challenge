import java.util.ArrayList;
import java.util.List;

public class Customer {
    private double balance;
    private final List<CartItem> cart;
    private static final double SHIPPING_FEE_PER_KG = 5.0;

    public Customer(double balance) {
        this.balance = balance;
        this.cart = new ArrayList<>();
    }

    public boolean addToCart(Product product , int quantity) {
        if(quantity <= 0) {
            System.out.println("Error: Quantity must be positive");
            return false;
        }
        if(product.isExpired()) {
            System.out.println("Error: Product " + product.getName() + " is expired");
            return false;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Error: Insufficient stock for " + product.getName() +  ". Available: " + product.getQuantity());
            return false;
        }

        cart.add(new CartItem(product , quantity));
        return true;
    }

    public void checkout(ShippingService shippingService) {
        if(cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }
        double subtotal = 0;
        double totalWeight = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for(CartItem item : cart) {
            Product product = item.getProduct();
            if(!product.reduceQuantity(item.getQuantity())) {
                System.out.println("Error: Product " + product.getName() + " is out of stock");
                return;
            }
            subtotal += item.getSubTotal();
            if(product.requiresShipping()) {
                shippableItems.add(new Shippable() {
                    public String getName() {return product.getName();}
                    public double getWeight() {return product.getWeight();}
                });
                totalWeight += product.getWeight() * item.getQuantity();
            }
        }
        double shippingFees = totalWeight * SHIPPING_FEE_PER_KG;
        double totalAmount = subtotal + shippingFees;

        if(totalAmount > balance) {
            System.out.println("Error: Insufficient balance. Required: $" + totalAmount + ", Available: $" + balance);
        }

        balance -= totalAmount;
        System.out.println("Checkout Details:");
        System.out.println("Order Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Shipping Fees: $" + String.format("%.2f", shippingFees));
        System.out.println("Total Paid Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("Remaining Balance: $" + String.format("%.2f", balance));

        if (!shippableItems.isEmpty()) {
            shippingService.shipitems(shippableItems);
        }

        cart.clear();
    }
}
