package Model;

public class Chef extends Staff {

    private String specialization; // e.g. "BBQ", "Desserts", "Karahi"

    public Chef() {}

    public Chef(int staffId, String name, String phone, String email,
                String password, double salary, String status, String specialization) {
        super(staffId, name, phone, email, password, "Chef", salary, status);
        this.specialization = specialization;
    }

    @Override
    public String getDuties() {
        return "Prepare food orders, manage kitchen hygiene, coordinate with inventory.";
    }

    public String getSpecialization()            { return specialization; }
    public void setSpecialization(String spec)   { this.specialization = spec; }
}