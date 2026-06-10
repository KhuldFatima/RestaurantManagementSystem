package Dto;

import java.util.List;
import Model.OrderItem;

public class OrderRequest {
    private List<OrderItem> cartItems;
    private double subtotal;
    private String paymentMethod; // e.g., "ASKARI", "MEEZAN", "CASH"
    private int tableNumber;      // The table this order belongs to

    public OrderRequest() {}

    public OrderRequest(List<OrderItem> cartItems, double subtotal, String paymentMethod, int tableNumber) {
        this.cartItems     = cartItems;
        this.subtotal      = subtotal;
        this.paymentMethod = paymentMethod;
        this.tableNumber   = tableNumber;
    }

    public List<OrderItem> getCartItems() { return cartItems; }
    public void setCartItems(List<OrderItem> cartItems) { this.cartItems = cartItems; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
}
