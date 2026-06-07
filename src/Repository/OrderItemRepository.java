package Repository;

import Database.DatabaseConnection;
import Model.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderItemRepository {

    public boolean saveOrderItems(int orderId, List<OrderItem> items) {
        String query = "INSERT INTO order_items (order_id, menu_item_id, item_name, quantity, unit_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            for (OrderItem item : items) {
                stmt.setInt(1, orderId);
                stmt.setInt(2, item.getMenuItemId());
                stmt.setString(3, item.getItemName());
                stmt.setInt(4, item.getQuantity());
                stmt.setDouble(5, item.getUnitPrice());
                stmt.addBatch();
            }

            int[] results = stmt.executeBatch();
            return results.length == items.size();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}