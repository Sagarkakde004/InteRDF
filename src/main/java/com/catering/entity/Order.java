package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Order number is required")
    @Size(max = 50, message = "Order number cannot exceed 50 characters")
    @Column(name = "order_number", unique = true, nullable = false, length = 50)
    private String orderNumber;
    
    @NotNull(message = "Customer is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;
    
    @NotNull(message = "Order date is required")
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;
    
    @NotNull(message = "Event date is required")
    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;
    
    @Column(name = "event_time")
    private LocalTime eventTime;
    
    @NotBlank(message = "Venue is required")
    @Size(max = 200, message = "Venue cannot exceed 200 characters")
    @Column(nullable = false, length = 200)
    private String venue;
    
    @Min(value = 1, message = "Guest count must be at least 1")
    @Column(name = "guest_count", nullable = false)
    private Integer guestCount;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.PENDING;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    
    @DecimalMin(value = "0.0", message = "Total amount must be positive")
    @Column(name = "total_amount", precision = 12, scale = 2)
    private BigDecimal totalAmount = BigDecimal.ZERO;
    
    @DecimalMin(value = "0.0", message = "Advance amount must be positive")
    @Column(name = "advance_amount", precision = 12, scale = 2)
    private BigDecimal advanceAmount = BigDecimal.ZERO;
    
    @DecimalMin(value = "0.0", message = "Remaining amount must be positive")
    @Column(name = "remaining_amount", precision = 12, scale = 2)
    private BigDecimal remainingAmount = BigDecimal.ZERO;
    
    @Column(name = "special_instructions", columnDefinition = "TEXT")
    private String specialInstructions;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderEmployee> employeeAssignments = new ArrayList<>();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderInventoryItem> inventoryAssignments = new ArrayList<>();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();
    
    // Constructors
    public Order() {}
    
    public Order(String orderNumber, Customer customer, OrderType orderType, LocalDate orderDate, 
                 LocalDate eventDate, String venue, Integer guestCount) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.eventDate = eventDate;
        this.venue = venue;
        this.guestCount = guestCount;
    }
    
    // Business Methods
    public void calculateRemainingAmount() {
        this.remainingAmount = this.totalAmount.subtract(this.advanceAmount);
    }
    
    public boolean isFullyPaid() {
        return PaymentStatus.FULLY_PAID.equals(this.paymentStatus);
    }
    
    public boolean isCompleted() {
        return OrderStatus.COMPLETED.equals(this.orderStatus);
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public OrderType getOrderType() {
        return orderType;
    }
    
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    
    public LocalDate getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    public LocalDate getEventDate() {
        return eventDate;
    }
    
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    
    public LocalTime getEventTime() {
        return eventTime;
    }
    
    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }
    
    public String getVenue() {
        return venue;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }
    
    public Integer getGuestCount() {
        return guestCount;
    }
    
    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }
    
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        calculateRemainingAmount();
    }
    
    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }
    
    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
        calculateRemainingAmount();
    }
    
    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }
    
    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
    
    public String getSpecialInstructions() {
        return specialInstructions;
    }
    
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public User getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public List<OrderEmployee> getEmployeeAssignments() {
        return employeeAssignments;
    }
    
    public void setEmployeeAssignments(List<OrderEmployee> employeeAssignments) {
        this.employeeAssignments = employeeAssignments;
    }
    
    public List<OrderInventoryItem> getInventoryAssignments() {
        return inventoryAssignments;
    }
    
    public void setInventoryAssignments(List<OrderInventoryItem> inventoryAssignments) {
        this.inventoryAssignments = inventoryAssignments;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderType=" + orderType +
                ", orderDate=" + orderDate +
                ", eventDate=" + eventDate +
                ", venue='" + venue + '\'' +
                ", guestCount=" + guestCount +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

enum OrderType {
    FULL_CATERING, HALF_CATERING
}

enum OrderStatus {
    PENDING, IN_PROGRESS, COMPLETED, CANCELLED
}

enum PaymentStatus {
    PENDING, ADVANCE_PAID, FULLY_PAID
}

