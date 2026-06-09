package Model;

public class Table {

    public static final String STATUS_AVAILABLE  = "AVAILABLE";
    public static final String STATUS_OCCUPIED   = "OCCUPIED";
    public static final String STATUS_RESERVED   = "RESERVED";
    public static final String STATUS_CLEANING   = "CLEANING";

    private int tableId;
    private int tableNumber;
    private int capacity;
    private String status;
    private int assignedWaiterId;

    public Table() {}

    public Table(int tableId, int tableNumber, int capacity,
                 String status, int assignedWaiterId) {
        this.tableId          = tableId;
        this.tableNumber      = tableNumber;
        this.capacity         = capacity;
        this.status           = status;
        this.assignedWaiterId = assignedWaiterId;
    }

    public int getTableId()                    { return tableId; }
    public void setTableId(int id)             { this.tableId = id; }

    public int getTableNumber()                { return tableNumber; }
    public void setTableNumber(int num)        { this.tableNumber = num; }

    public int getCapacity()                   { return capacity; }
    public void setCapacity(int cap)           { this.capacity = cap; }

    public String getStatus()                  { return status; }
    public void setStatus(String status)       { this.status = status; }

    public int getAssignedWaiterId()           { return assignedWaiterId; }
    public void setAssignedWaiterId(int id)    { this.assignedWaiterId = id; }

    public boolean isAvailable() {
        return STATUS_AVAILABLE.equals(this.status);
    }

    @Override
    public String toString() {
        return "Table #" + tableNumber + " | Capacity: " + capacity + " | " + status;
    }
}