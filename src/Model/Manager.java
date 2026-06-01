package Model;

public class Manager extends Staff {

    private String department;

    public Manager() {}

    public Manager(int staffId, String name, String phone, String email,
                   String password, double salary, String status, String department) {
        super(staffId, name, phone, email, password, "Manager", salary, status);
        this.department = department;
    }

    @Override
    public String getDuties() {
        return "Oversee restaurant operations, manage staff, approve discounts, review daily reports.";
    }

    public String getDepartment()              { return department; }
    public void setDepartment(String dept)     { this.department = dept; }
}