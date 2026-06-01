package Model;

import java.time.LocalDateTime;

public class Bill {

    public static final String STATUS_UNPAID = "Unpaid";
    public static final String STATUS_PAID   = "Paid";

    public static final String PAYMENT_CASH  = "Cash";
    public static final String PAYMENT_CARD  = "Card";

    private int billId;
    private int orderId;
    private int tableId;
    private double subtotal;
    private double discountAmount;
    private double taxAmount;      // 16% GST for Pakistan
    private double totalAmount;
    private String paymentMethod;
    private String status;
    private LocalDateTime billTime;
    private int cashierId;

    public Bill() {
        this.billTime = LocalDateTime.now();
        this.status   = STATUS_UNPAID;
    }

    public Bill(int billId, int orderId, int tableId, double subtotal,
                double discountAmount, double taxAmount, double totalAmount,
                String paymentMethod, String status, LocalDateTime billTime, int cashierId) {
        this.billId        = billId;
        this.orderId       = orderId;
        this.tableId       = tableId;
        this.subtotal      = subtotal;
        this.discountAmount = discountAmount;
        this.taxAmount     = taxAmount;
        this.totalAmount   = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status        = status;
        this.billTime      = billTime;
        this.cashierId     = cashierId;
    }

    public void calculateTotal() {
        double afterDiscount = subtotal - discountAmount;
        this.taxAmount   = afterDiscount * 0.16; // 16% GST
        this.totalAmount = afterDiscount + taxAmount;
    }

    public int getBillId()                        { return billId; }
    public void setBillId(int id)                 { this.billId = id; }

    public int getOrderId()                       { return orderId; }
    public void setOrderId(int id)                { this.orderId = id; }

    public int getTableId()                       { return tableId; }
    public void setTableId(int id)                { this.tableId = id; }

    public double getSubtotal()                   { return subtotal; }
    public void setSubtotal(double sub)           { this.subtotal = sub; }

    public double getDiscountAmount()             { return discountAmount; }
    public void setDiscountAmount(double disc)    { this.discountAmount = disc; }

    public double getTaxAmount()                  { return taxAmount; }
    public void setTaxAmount(double tax)          { this.taxAmount = tax; }

    public double getTotalAmount()                { return totalAmount; }
    public void setTotalAmount(double total)      { this.totalAmount = total; }

    public String getPaymentMethod()              { return paymentMethod; }
    public void setPaymentMethod(String method)   { this.paymentMethod = method; }

    public String getStatus()                     { return status; }
    public void setStatus(String status)          { this.status = status; }

    public LocalDateTime getBillTime()            { return billTime; }
    public void setBillTime(LocalDateTime time)   { this.billTime = time; }

    public int getCashierId()                     { return cashierId; }
    public void setCashierId(int id)              { this.cashierId = id; }

    @Override
    public String toString() {
        return "Bill #" + billId + " | Order #" + orderId + " | Total: Rs. " + totalAmount + " | " + status;
    }
}