package Model;

public abstract class Staff {

    private int staffId;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String role;
    private double salary;
    private String status;

    public Staff() {}

    public Staff(int staffId, String name, String phone, String email,
                 String password, String role, double salary, String status) {
        this.staffId  = staffId;
        this.name     = name;
        this.phone    = phone;
        this.email    = email;
        this.password = password;
        this.role     = role;
        this.salary   = salary;
        this.status   = status;
    }

    //each role duties
    public abstract String getDuties();

    public int getStaffId()            { return staffId; }
    public void setStaffId(int id)     { this.staffId = id; }

    public String getName()            { return name; }
    public void setName(String name)   { this.name = name; }

    public String getPhone()           { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail()             { return email; }
    public void setEmail(String email)   { this.email = email; }

    public String getPassword()              { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole()            { return role; }
    public void setRole(String role)   { this.role = role; }

    public double getSalary()          { return salary; }
    public void setSalary(double s)    { this.salary = s; }

    public String getStatus()          { return status; }
    public void setStatus(String s)    { this.status = s; }

    @Override
    public String toString() {
        return "[" + role + "] " + name + " | " + phone;
    }
}
