package Model;

public class Waiter {
    private int waiterId;
    private String name;
    private int assignedTableNumber;
    private boolean isAvailable;

    public Waiter() {}

    public Waiter(int waiterId, String name, int assignedTableNumber, boolean isAvailable) {
        this.waiterId = waiterId;
        this.name = name;
        this.assignedTableNumber = assignedTableNumber;
        this.isAvailable = isAvailable;
    }

    public int getWaiterId() { return waiterId; }
    public void setWaiterId(int waiterId) { this.waiterId = waiterId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAssignedTableNumber() { return assignedTableNumber; }
    public void setAssignedTableNumber(int assignedTableNumber) { this.assignedTableNumber = assignedTableNumber; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}