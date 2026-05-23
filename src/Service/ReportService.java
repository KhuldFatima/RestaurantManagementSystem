package Service;

import Database.DatabaseConnection;
import Util.Helpers;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    // Total revenue for today
    public double getTodayRevenue() {
        String sql = "SELECT COALESCE(SUM(total), 0) FROM orders " +
                "WHERE status='paid' AND DATE(created_at) = CURDATE()";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Total revenue overall
    public double getTotalRevenue() {
        String sql = "SELECT COALESCE(SUM(total), 0) FROM orders WHERE status='paid'";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Count of orders today
    public int getTodayOrderCount() {
        String sql = "SELECT COUNT(*) FROM orders " +
                "WHERE status='paid' AND DATE(created_at) = CURDATE()";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Top 5 most ordered items — returns list of String[] {name, quantity}
    public List<String[]> getTopSellingItems() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT m.name, SUM(oi.quantity) as total_qty " +
                "FROM order_items oi " +
                "JOIN menu_items m ON oi.menu_item_id = m.id " +
                "GROUP BY m.name ORDER BY total_qty DESC LIMIT 5";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{rs.getString("name"), String.valueOf(rs.getInt("total_qty"))});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Revenue per day for last 7 days — returns Map<date, revenue>
    public Map<String, Double> getLast7DaysRevenue() {
        Map<String, Double> map = new LinkedHashMap<>();
        String sql = "SELECT DATE(created_at) as day, SUM(total) as rev " +
                "FROM orders WHERE status='paid' " +
                "AND created_at >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) " +
                "GROUP BY day ORDER BY day";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                map.put(rs.getString("day"), rs.getDouble("rev"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    // Revenue per category
    public Map<String, Double> getRevenueByCategory() {
        Map<String, Double> map = new LinkedHashMap<>();
        String sql = "SELECT m.category, SUM(oi.subtotal) as rev " +
                "FROM order_items oi " +
                "JOIN menu_items m ON oi.menu_item_id = m.id " +
                "GROUP BY m.category ORDER BY rev DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                map.put(rs.getString("category"), rs.getDouble("rev"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    // All orders list — returns list of String[] {id, table, total, date, status}
    public List<String[]> getAllOrders() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT o.id, t.table_number, o.total, o.created_at, o.status " +
                "FROM orders o JOIN tables t ON o.table_id = t.id " +
                "ORDER BY o.created_at DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                        String.valueOf(rs.getInt("id")),
                        "Table " + rs.getInt("table_number"),
                        Helpers.formatCurrency(rs.getDouble("total")),
                        Helpers.formatDate(rs.getTimestamp("created_at")),
                        rs.getString("status")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}