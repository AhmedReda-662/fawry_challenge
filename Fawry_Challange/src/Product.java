import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpired;
    private LocalDate expireDate;
    private boolean isShippable;
    private double weight;

    public Product(String name,
                   double price,
                   int quantity,
                   boolean isExpired,
                   LocalDate expireDate,
                   boolean isShippable,
                   double weight
                   ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpired = isExpired;
        this.expireDate = expireDate;
        this.isShippable = isShippable;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean canExpire() { return isExpired; }
    public LocalDate getExpirationDate() { return expireDate; }
    public boolean requiresShipping() { return isShippable; }
    public double getWeight() { return weight; }

    public boolean isExpired() {
        return isExpired && expireDate != null && expireDate.isBefore(LocalDate.now());
    }

    public boolean reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }
}
