package Model;

public class Waiter extends Staff {

    private int assignedTableId;

    public Waiter() {}

    public Waiter(int staffId, String name, String phone, String email,
                  String password, double salary, String status, int assignedTableId) {
        super(staffId, name, phone, email, password, "Waiter", salary, status);
        this.assignedTableId = assignedTableId;
    }

    @Override
    public String getDuties() {
        return "Take orders from customers, serve food, handle table requests.";
    }

    public int getAssignedTableId()          { return assignedTableId; }
    public void setAssignedTableId(int t)    { this.assignedTableId = t; }
}