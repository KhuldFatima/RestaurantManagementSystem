package Model;

public class MenuItem {

    // Categories for a Pakistani restaurant
    public static final String CAT_STARTERS    = "Starters";
    public static final String CAT_MAIN_COURSE = "Main Course";
    public static final String CAT_BIRYANI     = "Biryani & Rice";
    public static final String CAT_BREADS      = "Breads";
    public static final String CAT_SIDES       = "Side Dishes";
    public static final String CAT_DESSERTS    = "Desserts";
    public static final String CAT_DRINKS      = "Drinks";
    public static final String CAT_BBQ         = "BBQ & Grills";

    private int itemId;
    private String name;
    private String category;
    private double price;
    private String description;
    private boolean available;

    public MenuItem() {}

    public MenuItem(int itemId, String name, String category,
                    double price, String description, boolean available) {
        this.itemId      = itemId;
        this.name        = name;
        this.category    = category;
        this.price       = price;
        this.description = description;
        this.available   = available;
    }

    // Getters & Setters
    public int getItemId()                   { return itemId; }
    public void setItemId(int id)            { this.itemId = id; }

    public String getName()                  { return name; }
    public void setName(String name)         { this.name = name; }

    public String getCategory()              { return category; }
    public void setCategory(String cat)      { this.category = cat; }

    public double getPrice()                 { return price; }
    public void setPrice(double price)       { this.price = price; }

    public String getDescription()           { return description; }
    public void setDescription(String desc)  { this.description = desc; }

    public boolean isAvailable()             { return available; }
    public void setAvailable(boolean avail)  { this.available = avail; }

    @Override
    public String toString() {
        return name + " (" + category + ") - Rs. " + price;
    }
}