package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final String STATUS_PENDING   = "Pending";
    public static final String STATUS_PREPARING = "Preparing";
    public static final String STATUS_READY     = "Ready";
    public static final String STATUS_SERVED    = "Served";
    public static final String STATUS_CANCELLED = "Cancelled";

    private int orderId;
    private int tableId;
    private int waiterId;
    private String status;
    private LocalDateTime orderTime;
    private String specialInstructions;
    private List<OrderItem> items;

    public Order() {
        this.items     = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.status    = STATUS_PENDING;
    }

    public Order(int orderId, int tableId, int waiterId,
                 String status, LocalDateTime orderTime, String specialInstructions) {
        this.orderId             = orderId;
        this.tableId             = tableId;
        this.waiterId            = waiterId;
        this.status              = status;
        this.orderTime           = orderTime;
        this.specialInstructions = specialInstructions;
        this.items               = new ArrayList<>();
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void addItem(OrderItem item)    { items.add(item); }
    public void removeItem(OrderItem item) { items.remove(item); }

    // Getters & Setters
    public int getOrderId()                          { return orderId; }
    public void setOrderId(int id)                   { this.orderId = id; }

    public int getTableId()                          { return tableId; }
    public void setTableId(int id)                   { this.tableId = id; }

    public int getWaiterId()                         { return waiterId; }
    public void setWaiterId(int id)                  { this.waiterId = id; }

    public String getStatus()                        { return status; }
    public void setStatus(String status)             { this.status = status; }

    public LocalDateTime getOrderTime()              { return orderTime; }
    public void setOrderTime(LocalDateTime time)     { this.orderTime = time; }

    public String getSpecialInstructions()           { return specialInstructions; }
    public void setSpecialInstructions(String instr) { this.specialInstructions = instr; }

    public List<OrderItem> getItems()                { return items; }
    public void setItems(List<OrderItem> items)      { this.items = items; }

    @Override
    public String toString() {
        return "Order #" + orderId + " | Table: " + tableId + " | Status: " + status;
    }
}