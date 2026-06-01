package Model;

public class Discount {

    public static final String TYPE_PERCENTAGE = "Percentage";
    public static final String TYPE_FLAT       = "Flat";

    private int discountId;
    private String name;        // e.g. "Ramadan Special", "Student Discount"
    private String type;        // Percentage or Flat
    private double value;       // e.g. 10 (for 10%) or 200 (for Rs.200 off)
    private boolean active;

    public Discount() {}

    public Discount(int discountId, String name, String type, double value, boolean active) {
        this.discountId = discountId;
        this.name       = name;
        this.type       = type;
        this.value      = value;
        this.active     = active;
    }

    public double applyDiscount(double subtotal) {
        if (!active) return 0;
        if (TYPE_PERCENTAGE.equals(type)) {
            return subtotal * (value / 100);
        } else {
            return Math.min(value, subtotal); // flat discount can't exceed subtotal
        }
    }

    public int getDiscountId()             { return discountId; }
    public void setDiscountId(int id)      { this.discountId = id; }

    public String getName()                { return name; }
    public void setName(String name)       { this.name = name; }

    public String getType()                { return type; }
    public void setType(String type)       { this.type = type; }

    public double getValue()               { return value; }
    public void setValue(double value)     { this.value = value; }

    public boolean isActive()             { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        String display = TYPE_PERCENTAGE.equals(type) ? value + "%" : "Rs. " + value;
        return name + " (" + display + " off)";
    }
}