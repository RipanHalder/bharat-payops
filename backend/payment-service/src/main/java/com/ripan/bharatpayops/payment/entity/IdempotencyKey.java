package com.bharatpayops.payment.entity;

@Entity
@Table(name="idempotency_keys")
public class IdempotencyKey {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="idempotency_key", nullable=false, unique=true, length=128)
    private String idempotencyKey;

    @Column(name="request_hash", nullable=false, length=128)
    private String requestHash;

    @Column(name="payment_id", nullable=false, length=64)
    private String paymentId;

    @Column(name="created_at", nullable=false)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}