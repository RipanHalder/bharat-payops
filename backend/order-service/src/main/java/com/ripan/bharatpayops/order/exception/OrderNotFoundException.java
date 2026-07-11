package com.ripan.bharatpayops.order.exception;

import org.hibernate.validator.constraints.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID orderId) {
        super("Order was not found with ID: " + orderId);
    }
}