package Dto;

public class TableRequest {
    private int tableNumber;
    private String newStatus; // e.g., "OCCUPIED", "AVAILABLE", "RESERVED"

    public TableRequest() {}

    public TableRequest(int tableNumber, String newStatus) {
        this.tableNumber = tableNumber;
        this.newStatus = newStatus;
    }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public String getNewStatus() { return newStatus; }
    public void setNewStatus(String newStatus) { this.newStatus = newStatus; }
}