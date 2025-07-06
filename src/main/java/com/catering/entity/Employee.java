package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Employee ID is required")
    @Size(max = 20, message = "Employee ID cannot exceed 20 characters")
    @Column(name = "employee_id", unique = true, nullable = false, length = 20)
    private String employeeId;
    
    @NotBlank(message = "Employee name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Column(nullable = false, length = 100)
    private String name;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number should be valid")
    @Column(nullable = false, length = 20)
    private String phone;
    
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email should be valid")
    @Column(length = 100)
    private String email;
    
    @Column(columnDefinition = "TEXT")
    private String address;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    private EmployeeType employeeType;
    
    @DecimalMin(value = "0.0", message = "Daily rate must be positive")
    @Column(name = "daily_rate", precision = 10, scale = 2)
    private BigDecimal dailyRate = BigDecimal.ZERO;
    
    @DecimalMin(value = "0.0", message = "Per order rate must be positive")
    @Column(name = "per_order_rate", precision = 10, scale = 2)
    private BigDecimal perOrderRate = BigDecimal.ZERO;
    
    @NotNull(message = "Hire date is required")
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderEmployee> orderAssignments = new ArrayList<>();
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskAssignment> taskAssignments = new ArrayList<>();
    
    // Constructors
    public Employee() {}
    
    public Employee(String employeeId, String name, String phone, EmployeeType employeeType, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.employeeType = employeeType;
        this.hireDate = hireDate;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
    
    public BigDecimal getDailyRate() {
        return dailyRate;
    }
    
    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }
    
    public BigDecimal getPerOrderRate() {
        return perOrderRate;
    }
    
    public void setPerOrderRate(BigDecimal perOrderRate) {
        this.perOrderRate = perOrderRate;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
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
    
    public List<OrderEmployee> getOrderAssignments() {
        return orderAssignments;
    }
    
    public void setOrderAssignments(List<OrderEmployee> orderAssignments) {
        this.orderAssignments = orderAssignments;
    }
    
    public List<TaskAssignment> getTaskAssignments() {
        return taskAssignments;
    }
    
    public void setTaskAssignments(List<TaskAssignment> taskAssignments) {
        this.taskAssignments = taskAssignments;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeType=" + employeeType +
                ", dailyRate=" + dailyRate +
                ", perOrderRate=" + perOrderRate +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }
}

enum EmployeeType {
    COOK, BAI, WAITER, DRIVER, DISPLAY_TABLE_BOY, SERVICE_BOY
}

