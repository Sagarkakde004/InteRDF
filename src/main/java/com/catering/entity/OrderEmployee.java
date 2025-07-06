package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_employees", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "employee_id"}))
@EntityListeners(AuditingEntityListener.class)
public class OrderEmployee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Order is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @NotNull(message = "Employee is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @CreatedDate
    @Column(name = "assigned_at", updatable = false)
    private LocalDateTime assignedAt;
    
    @DecimalMin(value = "0.0", message = "Payment amount must be positive")
    @Column(name = "payment_amount", precision = 10, scale = 2)
    private BigDecimal paymentAmount = BigDecimal.ZERO;
    
    @Column(name = "is_paid")
    private Boolean isPaid = false;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    // Constructors
    public OrderEmployee() {}
    
    public OrderEmployee(Order order, Employee employee, BigDecimal paymentAmount) {
        this.order = order;
        this.employee = employee;
        this.paymentAmount = paymentAmount;
    }
    
    // Business Methods
    public void markAsPaid() {
        this.isPaid = true;
    }
    
    public void markAsUnpaid() {
        this.isPaid = false;
    }
    
    public boolean isPaymentPending() {
        return !isPaid && paymentAmount.compareTo(BigDecimal.ZERO) > 0;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
    
    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }
    
    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public Boolean getIsPaid() {
        return isPaid;
    }
    
    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "OrderEmployee{" +
                "id=" + id +
                ", assignedAt=" + assignedAt +
                ", paymentAmount=" + paymentAmount +
                ", isPaid=" + isPaid +
                '}';
    }
}

