import java.util.List;

public class ShippingService {

    public void shipitems(List<Shippable> items) {
        System.out.println("Shipping the following items:");
        for(Shippable item : items) {
            System.out.println("- " + item.getName() + " (Weight: " + item.getWeight() + "kg)");
        }
    }
}
