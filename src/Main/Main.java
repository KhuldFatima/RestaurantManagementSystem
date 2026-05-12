package Main;
//TESTING DATABASE CONNECTION
//import Database.DatabaseConnection;
//import java.sql.Connection;
//
//public class Main {
//    public static void main(String[] args) {
//        Connection conn = DatabaseConnection.getConnection();
//
//        if (conn != null) {
//            System.out.println("Connected to database!");
//        } else {
//            System.out.println("Connection failed!");
//        }
//    }
//}
//adding new objects in menu
//import Model.Menu;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Menu item1 = new Menu(1, "Burger", 500);
//        Menu item2 = new Menu(02, "Pizza", 1200);
//
//        System.out.println(item1.getName());
//        System.out.println(item1.getPrice());
//        System.out.println(item2.getName());
//        System.out.println(item2.getPrice());
//
//    }
//}

import Model.MenuItem;
import Database.MenuDAO;
import Database.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        MenuDAO dao = new MenuDAO(conn);
        MenuItem item = new MenuItem(2, "Pizza", 1200);
        dao.addMenu(item);
    }
}