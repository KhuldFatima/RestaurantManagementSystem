package Model;

public class Inventory {

    private int inventoryId;
    private String itemName;
    private String unit;           // "kg", "litre", "pieces", "packets"
    private double quantityInStock;
    private double minimumThreshold; // alert when below this
    private double pricePerUnit;
    private String category;       // "Meat", "Vegetables", "Spices", "Beverages", "Dairy"
    private String lastUpdated;

    public Inventory() {}

    public Inventory(int inventoryId, String itemName, String unit,
                     double quantityInStock, double minimumThreshold,
                     double pricePerUnit, String category, String lastUpdated) {
        this.inventoryId       = inventoryId;
        this.itemName          = itemName;
        this.unit              = unit;
        this.quantityInStock   = quantityInStock;
        this.minimumThreshold  = minimumThreshold;
        this.pricePerUnit      = pricePerUnit;
        this.category          = category;
        this.lastUpdated       = lastUpdated;
    }

    public boolean isLowStock() {
        return quantityInStock <= minimumThreshold;
    }

    public void addStock(double quantity) {
        this.quantityInStock += quantity;
    }

    public boolean deductStock(double quantity) {
        if (quantityInStock >= quantity) {
            this.quantityInStock -= quantity;
            return true;
        }
        return false; // not enough stock
    }

    // Getters & Setters
    public int getInventoryId()                  { return inventoryId; }
    public void setInventoryId(int id)           { this.inventoryId = id; }

    public String getItemName()                  { return itemName; }
    public void setItemName(String name)         { this.itemName = name; }

    public String getUnit()                      { return unit; }
    public void setUnit(String unit)             { this.unit = unit; }

    public double getQuantityInStock()           { return quantityInStock; }
    public void setQuantityInStock(double qty)   { this.quantityInStock = qty; }

    public double getMinimumThreshold()          { return minimumThreshold; }
    public void setMinimumThreshold(double min)  { this.minimumThreshold = min; }

    public double getPricePerUnit()              { return pricePerUnit; }
    public void setPricePerUnit(double price)    { this.pricePerUnit = price; }

    public String getCategory()                  { return category; }
    public void setCategory(String cat)          { this.category = cat; }

    public String getLastUpdated()               { return lastUpdated; }
    public void setLastUpdated(String date)      { this.lastUpdated = date; }

    @Override
    public String toString() {
        return itemName + " | Stock: " + quantityInStock + " " + unit +
                (isLowStock() ? " ⚠ LOW STOCK" : "");
    }
}