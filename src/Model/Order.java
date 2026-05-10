package Model;

public class Order {

    // Attributes
    private int orderId;
    private String customerName;
    private String itemName;
    private int quantity;
    private double totalPrice;

    // Constructor
    public Order(int orderId, String customerName,
                 String itemName, int quantity,
                 double totalPrice) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // toString Method
    @Override
    public String toString() {

        return "Order ID: " + orderId +
                ", Customer Name: " + customerName +
                ", Item Name: " + itemName +
                ", Quantity: " + quantity +
                ", Total Price: " + totalPrice;
    }
}
