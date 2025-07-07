package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_inventory_items")
@EntityListeners(AuditingEntityListener.class)
public class OrderInventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Order is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @NotNull(message = "Inventory item is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_item_id", nullable = false)
    private InventoryItem inventoryItem;
    
    @Min(value = 1, message = "Quantity assigned must be at least 1")
    @Column(name = "quantity_assigned", nullable = false)
    private Integer quantityAssigned;
    
    @Min(value = 0, message = "Quantity returned cannot be negative")
    @Column(name = "quantity_returned")
    private Integer quantityReturned = 0;
    
    @CreatedDate
    @Column(name = "assigned_at", updatable = false)
    private LocalDateTime assignedAt;
    
    @Column(name = "returned_at")
    private LocalDateTime returnedAt;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    // Constructors
    public OrderInventoryItem() {}
    
    public OrderInventoryItem(Order order, InventoryItem inventoryItem, Integer quantityAssigned) {
        this.order = order;
        this.inventoryItem = inventoryItem;
        this.quantityAssigned = quantityAssigned;
    }
    
    // Business Methods
    public boolean isFullyReturned() {
        return quantityReturned.equals(quantityAssigned);
    }
    
    public boolean isPartiallyReturned() {
        return quantityReturned > 0 && quantityReturned < quantityAssigned;
    }
    
    public Integer getPendingReturnQuantity() {
        return quantityAssigned - quantityReturned;
    }
    
    public void returnItems(Integer quantity) {
        if (quantity > 0 && (quantityReturned + quantity) <= quantityAssigned) {
            this.quantityReturned += quantity;
            if (isFullyReturned()) {
                this.returnedAt = LocalDateTime.now();
            }
        }
    }
    
    public void returnAllItems() {
        this.quantityReturned = this.quantityAssigned;
        this.returnedAt = LocalDateTime.now();
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
    
    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }
    
    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
    
    public Integer getQuantityAssigned() {
        return quantityAssigned;
    }
    
    public void setQuantityAssigned(Integer quantityAssigned) {
        this.quantityAssigned = quantityAssigned;
    }
    
    public Integer getQuantityReturned() {
        return quantityReturned;
    }
    
    public void setQuantityReturned(Integer quantityReturned) {
        this.quantityReturned = quantityReturned;
    }
    
    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
    
    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    
    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }
    
    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "OrderInventoryItem{" +
                "id=" + id +
                ", quantityAssigned=" + quantityAssigned +
                ", quantityReturned=" + quantityReturned +
                ", assignedAt=" + assignedAt +
                ", returnedAt=" + returnedAt +
                '}';
    }
}

