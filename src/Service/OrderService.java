package Service;

import controller.OrderController;
import controller.TableController;
import model.OrderItem;
import util.Constants;
import util.Helpers;

import java.util.List;

public class OrderService {
    private OrderController orderController = new OrderController();
    private TableController tableController = new TableController();

    // Main method to place a full order
    // Returns error message or null if successful
    public String placeOrder(int tableId, List<OrderItem> items) {
        if (tableId <= 0)                      return Constants.MSG_SELECT_TABLE;
        if (items == null || items.isEmpty())  return Constants.MSG_ORDER_EMPTY;

        double total = calculateTotal(items);

        int orderId = orderController.createOrder(tableId);
        if (orderId == -1) return Constants.MSG_DB_ERROR;

        for (OrderItem item : items) {
            boolean added = orderController.addItemToOrder(orderId, item);
            if (!added) return "Failed to add item: " + item.getMenuItem().getName();
        }

        boolean closed = orderController.closeOrder(orderId, total);
        if (!closed) return "Order created but could not be finalized.";

        // Mark table as available again after payment
        tableController.updateTableStatus(tableId, Constants.TABLE_AVAILABLE);

        return null; // null means success
    }

    public double calculateTotal(List<OrderItem> items) {
        if (items == null) return 0;
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return Helpers.roundToTwo(total);
    }

    public String generateBillText(List<OrderItem> items, int tableId) {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================\n");
        sb.append("   RESTAURANT BILL\n");
        sb.append("==============================\n");
        sb.append("Table No: ").append(tableId).append("\n");
        sb.append("Date: ").append(Helpers.getCurrentDateTime()).append("\n");
        sb.append("------------------------------\n");
        for (OrderItem item : items) {
            sb.append(String.format("%-20s x%d\n", item.getMenuItem().getName(), item.getQuantity()));
            sb.append(String.format("  %s\n", Helpers.formatCurrency(item.getSubtotal())));
        }
        sb.append("------------------------------\n");
        sb.append(String.format("TOTAL:  %s\n", Helpers.formatCurrency(calculateTotal(items))));
        sb.append("==============================\n");
        sb.append("   Thank you! Come again.\n");
        sb.append("==============================\n");
        return sb.toString();
    }
}