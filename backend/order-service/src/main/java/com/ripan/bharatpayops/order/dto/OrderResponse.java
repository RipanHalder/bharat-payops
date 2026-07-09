package com.ripan.bharatpayops.order.dto;

public class OrderResponse {

    private String orderId;
    private String customerId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private String status;

    public OrderResponse(String orderId, String customerId, String merchantId, BigDecimal amount, String currency, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public static OrderResponse fromEntity(OrderEntity orderEntity) {
        return new OrderResponse(
                orderEntity.getId().toString(),
                orderEntity.getCustomerId(),
                orderEntity.getMerchantId(),
                orderEntity.getAmount(),
                orderEntity.getCurrency(),
                orderEntity.getStatus().name()
        );
    }

    // Getters
    public String getOrderId() {
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

    public String getStatus() {
        return status;
    }
}