package Service;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReportService {

    public Map<String, Object> getDailyPerformanceMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        String query = "SELECT SUM(subtotal) as gross, SUM(discount) as total_disc, SUM(gst_tax) as total_tax, SUM(total_paid) as net_rev FROM daily_sales WHERE DATE(sale_time) = CURDATE()";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                metrics.put("grossRevenue", rs.getDouble("gross"));
                metrics.put("discountsGiven", rs.getDouble("total_disc"));
                metrics.put("taxCollected", rs.getDouble("total_tax"));
                metrics.put("netRevenue", rs.getDouble("net_rev"));
            } else {
                metrics.put("grossRevenue", 0.0);
                metrics.put("discountsGiven", 0.0);
                metrics.put("taxCollected", 0.0);
                metrics.put("netRevenue", 0.0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            metrics.put("error", "Failed to compile: " + e.getMessage());
        }
        return metrics;
    }
}