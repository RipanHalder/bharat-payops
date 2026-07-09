package com.ripan.bharatpayops.order.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID orderId) {
        super("Order was not found with ID: " + orderId);
    }
}