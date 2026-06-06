package Model;

import java.time.LocalDateTime;

public class Reservation {
    private int reservationId;
    private String customerName;
    private String customerPhone;
    private int tableNumber;
    private LocalDateTime reservationTime;
    private int numberOfGuests;

    public Reservation() {}

    public Reservation(int reservationId, String customerName, String customerPhone, int tableNumber, LocalDateTime reservationTime, int numberOfGuests) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.tableNumber = tableNumber;
        this.reservationTime = reservationTime;
        this.numberOfGuests = numberOfGuests;
    }

    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public LocalDateTime getReservationTime() { return reservationTime; }
    public void setReservationTime(LocalDateTime reservationTime) { this.reservationTime = reservationTime; }

    public int getNumberOfGuests() { return numberOfGuests; }
    public void setNumberOfGuests(int numberOfGuests) { this.numberOfGuests = numberOfGuests; }
}