package com.ripan.bharatpayops.order.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String merchantId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    protected OrderEntity() {
        // Default constructor for JPA
    }

    public OrderEntity(String customerId, String merchantId, BigDecimal amount, String currency) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.status = OrderStatus.CREATED;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    // Getters and setters
    public UUID getId() {
        return id;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void markPaymentPending() {
        this.status = OrderStatus.PAYMENT_PENDING;
        this.updatedAt = Instant.now();
    }

    public void markPaid() {
        this.status = OrderStatus.PAID;
        this.updatedAt = Instant.now();
    }

    public void markPaymentFailed() {
        this.status = OrderStatus.PAYMENT_FAILED;
        this.updatedAt = Instant.now();
    }

    public void markCancelled() {
        this.status = OrderStatus.CANCELLED;
        this.updatedAt = Instant.now();
    }
}