package com.ripan.bharatpayops.order.dto;

import com.ripan.bharatpayops.order.entity.OrderEntity;
import com.ripan.bharatpayops.order.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class OrderResponse {

    private UUID orderId;
    private String customerId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private OrderStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    public OrderResponse(UUID orderId, String customerId, String merchantId, BigDecimal amount,
                         String currency, OrderStatus status, Instant createdAt, Instant updatedAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static OrderResponse from(OrderEntity orderEntity) {
        return new OrderResponse(
                orderEntity.getId(),
                orderEntity.getCustomerId(),
                orderEntity.getMerchantId(),
                orderEntity.getAmount(),
                orderEntity.getCurrency(),
                orderEntity.getStatus(),
                orderEntity.getCreatedAt(),
                orderEntity.getUpdatedAt()
        );
    }

    // Getters
    public UUID getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public OrderStatus getStatus() {
        return status;
    }
}