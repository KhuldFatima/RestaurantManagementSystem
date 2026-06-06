package Model;

public class Staff {
    private int staffId;
    private String name;
    private String role; // e.g., "CHEF", "CLEANER", "SECURITY"
    private double salary;
    private String status; // "ACTIVE", "ON_LEAVE", "TERMINATED"

    public Staff() {}

    public Staff(int staffId, String name, String role, double salary, String status) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.status = status;
    }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}