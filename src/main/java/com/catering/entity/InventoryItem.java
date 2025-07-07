package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventory_items")
@EntityListeners(AuditingEntityListener.class)
public class InventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Item code is required")
    @Size(max = 50, message = "Item code cannot exceed 50 characters")
    @Column(name = "item_code", unique = true, nullable = false, length = 50)
    private String itemCode;
    
    @NotBlank(message = "Item name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InventoryCategory category;
    
    @NotBlank(message = "Unit is required")
    @Size(max = 20, message = "Unit cannot exceed 20 characters")
    @Column(nullable = false, length = 20)
    private String unit;
    
    @Min(value = 0, message = "Current stock cannot be negative")
    @Column(name = "current_stock")
    private Integer currentStock = 0;
    
    @Min(value = 0, message = "Minimum stock cannot be negative")
    @Column(name = "minimum_stock")
    private Integer minimumStock = 0;
    
    @DecimalMin(value = "0.0", message = "Unit cost must be positive")
    @Column(name = "unit_cost", precision = 10, scale = 2)
    private BigDecimal unitCost = BigDecimal.ZERO;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "inventoryItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderInventoryItem> orderAssignments = new ArrayList<>();
    
    // Constructors
    public InventoryItem() {}
    
    public InventoryItem(String itemCode, String name, InventoryCategory category, String unit) {
        this.itemCode = itemCode;
        this.name = name;
        this.category = category;
        this.unit = unit;
    }
    
    // Business Methods
    public boolean isLowStock() {
        return currentStock <= minimumStock;
    }
    
    public boolean isOutOfStock() {
        return currentStock <= 0;
    }
    
    public void addStock(Integer quantity) {
        this.currentStock += quantity;
    }
    
    public boolean removeStock(Integer quantity) {
        if (this.currentStock >= quantity) {
            this.currentStock -= quantity;
            return true;
        }
        return false;
    }
    
    public BigDecimal getTotalValue() {
        return unitCost.multiply(BigDecimal.valueOf(currentStock));
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getItemCode() {
        return itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public InventoryCategory getCategory() {
        return category;
    }
    
    public void setCategory(InventoryCategory category) {
        this.category = category;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public Integer getCurrentStock() {
        return currentStock;
    }
    
    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }
    
    public Integer getMinimumStock() {
        return minimumStock;
    }
    
    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }
    
    public BigDecimal getUnitCost() {
        return unitCost;
    }
    
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
    
    public List<OrderInventoryItem> getOrderAssignments() {
        return orderAssignments;
    }
    
    public void setOrderAssignments(List<OrderInventoryItem> orderAssignments) {
        this.orderAssignments = orderAssignments;
    }
    
    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", unit='" + unit + '\'' +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                ", unitCost=" + unitCost +
                ", isActive=" + isActive +
                '}';
    }
}

enum InventoryCategory {
    UTENSILS, DISPLAY_TABLES, WATER_CANS, VEGETABLES, GROCERY, OTHER
}

