package Model;

public class MenuItem {
    private int id;
    private String name;
    private String category; // e.g., BBQ, Karahi, Rice, Drinks
    private double price;    // in PKR

    public MenuItem(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}