package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Menu;

public class MenuDAO {
    private Connection conn;
    public MenuDAO(Connection conn) {
        this.conn = conn;
    }

    public void addMenu(Menu item) {
        String query = "INSERT INTO menu (id, name, price) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setDouble(3, item.getPrice());
            stmt.executeUpdate();

            System.out.println("Menu item added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}