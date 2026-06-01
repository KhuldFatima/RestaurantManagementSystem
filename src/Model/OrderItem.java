package Model;

public class OrderItem {

    private int orderItemId;
    private int orderId;
    private int menuItemId;
    private String menuItemName;
    private int quantity;
    private double unitPrice;
    private String notes;

    public OrderItem() {}

    public OrderItem(int orderItemId, int orderId, int menuItemId,
                     String menuItemName, int quantity, double unitPrice, String notes) {
        this.orderItemId  = orderItemId;
        this.orderId      = orderId;
        this.menuItemId   = menuItemId;
        this.menuItemName = menuItemName;
        this.quantity     = quantity;
        this.unitPrice    = unitPrice;
        this.notes        = notes;
    }

    public double getSubtotal() {
        return quantity * unitPrice;
    }

    public int getOrderItemId()              { return orderItemId; }
    public void setOrderItemId(int id)       { this.orderItemId = id; }

    public int getOrderId()                  { return orderId; }
    public void setOrderId(int id)           { this.orderId = id; }

    public int getMenuItemId()               { return menuItemId; }
    public void setMenuItemId(int id)        { this.menuItemId = id; }

    public String getMenuItemName()          { return menuItemName; }
    public void setMenuItemName(String name) { this.menuItemName = name; }

    public int getQuantity()                 { return quantity; }
    public void setQuantity(int qty)         { this.quantity = qty; }

    public double getUnitPrice()             { return unitPrice; }
    public void setUnitPrice(double price)   { this.unitPrice = price; }

    public String getNotes()                 { return notes; }
    public void setNotes(String notes)       { this.notes = notes; }

    @Override
    public String toString() {
        return menuItemName + " x" + quantity + " = Rs. " + getSubtotal();
    }
}