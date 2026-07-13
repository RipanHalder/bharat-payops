package com.ripan.bharatpayops.payment.entity;

@Entity
@Table(name="payments"
    indexes= {
        @Index(name="idx_payment_id" columnList= "payment_id"),
        @Index(name="idx_order_id" columnList="order_id"),
        @Index(name="idx_user_id" columnList="user_id")
        }
)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="payment_id", nullable=false, unique=true, length=64)
    private String paymentId;

    @Column(name="order_id", nullable=false, length=64)
    private String orderId;

    @Column(name="user_id", nullable=false, length=64)
    private String userId;

    @Enumerated(EnumType.String)
    @Column(name="payment_method" nullable=false, length=32)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.String)
    @Column(nullable=false, length=32)
    private PaymentStatus status;

    // BigDecimal instead of Double to avoid decimal truncation / rounding-off
    // Precision = Total number of max digits. Scale = Decimal Deigits max
    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal amount;

    @Column(nullable=false, length=8)
    private String currency;

    @Column(name = "gateway_reference_id", nullable=false, length=128)
    private String gatewayReferenceId;

    @Column(name="failure_reason")
    private String failureReason;

    @Column(name="created_at", nullable=false)
    private Instant createdAt;

    @Column(name="updated_at", nullable=false)
    private Instant updatedAt;

    /* B4 the transactional runs, on the actual INSERT query to
       create payment is done on the db, prePersist is called */
    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    /* B4 the transactional runs, on the actual UPDATE query to
       update payment is done on the db, preUpdate is called */
    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    //Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGatewayReferenceId() {
        return gatewayReferenceId;
    }

    public void setGatewayReferenceId(String gatewayReferenceId) {
        this.gatewayReferenceId = gatewayReferenceId;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}