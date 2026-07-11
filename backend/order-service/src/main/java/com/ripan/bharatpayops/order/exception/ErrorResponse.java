package com.ripan.bharatpayops.order.exception;

import java.time.Instant;

public class ErrorResponse {

    private Instant timestamp;
    private String message;
    private String error;
    private int status;

    public ErrorResponse(int status, String error, String message) {
        this.timestamp = Instant.now();
        this.message = message;
        this.error = error;
        this.status = status;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getError() {
        return error;
    }
    public int getStatus() {
        return status;
    }
}
