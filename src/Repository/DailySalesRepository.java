package Repository;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DailySalesRepository {

    public boolean recordSale(double subtotal, double discountApplied, double taxAmount, double finalTotal, String paymentMethod) {
        String query = "INSERT INTO daily_sales (sale_time, subtotal, discount, gst_tax, total_paid, payment_method) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setDouble(2, subtotal);
            stmt.setDouble(3, discountApplied);
            stmt.setDouble(4, taxAmount);
            stmt.setDouble(5, finalTotal);
            stmt.setString(6, paymentMethod);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}