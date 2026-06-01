package Model;

public class Cashier extends Staff {

    private String shift; // "Morning", "Evening", "Night"

    public Cashier() {}

    public Cashier(int staffId, String name, String phone, String email,
                   String password, double salary, String status, String shift) {
        super(staffId, name, phone, email, password, "Cashier", salary, status);
        this.shift = shift;
    }

    @Override
    public String getDuties() {
        return "Handle billing, process payments, apply discounts, print receipts.";
    }

    public String getShift()           { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}