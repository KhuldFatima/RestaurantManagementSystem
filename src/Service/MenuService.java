package Service;

import Model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<MenuItem> localMenu = new ArrayList<>();

    public MenuService() {
        // Populating with traditional Pakistani menu items (Prices in PKR)
        localMenu.add(new MenuItem(1, "Chicken Makhni Handi (Half)", "Karahi", 1450.0));
        localMenu.add(new MenuItem(2, "Mutton Peshawari Karahi (Full)", "Karahi", 3200.0));
        localMenu.add(new MenuItem(3, "Beef Seekh Kebab (4 Pcs)", "BBQ", 850.0));
        localMenu.add(new MenuItem(4, "Chicken Tikka Piece (Leg)", "BBQ", 420.0));
        localMenu.add(new MenuItem(5, "Mutton Dum Biryani", "Rice", 780.0));
        localMenu.add(new MenuItem(6, "Garlic Naan / Roghni Naan", "Tandoor", 90.0));
        localMenu.add(new MenuItem(7, "Mint Raita & Fresh Salad", "Sides", 180.0));
        localMenu.add(new MenuItem(8, "Pakola / Soft Drink Can", "Drinks", 120.0));
    }

    public List<MenuItem> getAllMenuItems() {
        return localMenu;
    }
}