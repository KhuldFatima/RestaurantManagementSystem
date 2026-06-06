package Dto;

public class ApiResponse {
    private String status;  // e.g., "success", "fail", "error"
    private String message; // Explanatory message
    private Object data;    // Generic payload placeholder for any Model object or List

    public ApiResponse() {}

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}