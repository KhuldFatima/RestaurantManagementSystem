package Repository;

import Database.DatabaseConnection;
import Model.Order;
import java.sql.*;

public class OrderRepository {

    public int saveOrder(Order order) {
        String query = "INSERT INTO orders (table_number, subtotal, discount_amount, tax_amount, total_amount, payment_method, status, order_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, order.getTableNumber());
            stmt.setDouble(2, order.getSubtotal());
            stmt.setDouble(3, order.getDiscountAmount());
            stmt.setDouble(4, order.getTaxAmount());
            stmt.setDouble(5, order.getTotalAmount());
            stmt.setString(6, order.getPaymentMethod());
            stmt.setString(7, order.getStatus());
            stmt.setTimestamp(8, Timestamp.valueOf(order.getOrderTime()));

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Returns the newly created Order ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}