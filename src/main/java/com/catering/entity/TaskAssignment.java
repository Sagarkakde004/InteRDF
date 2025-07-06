package com.catering.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignments", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"task_id", "employee_id"}))
@EntityListeners(AuditingEntityListener.class)
public class TaskAssignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Task is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    
    @NotNull(message = "Employee is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @CreatedDate
    @Column(name = "assigned_at", updatable = false)
    private LocalDateTime assignedAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    // Constructors
    public TaskAssignment() {}
    
    public TaskAssignment(Task task, Employee employee) {
        this.task = task;
        this.employee = employee;
    }
    
    // Business Methods
    public boolean isCompleted() {
        return completedAt != null;
    }
    
    public void markAsCompleted() {
        this.completedAt = LocalDateTime.now();
    }
    
    public void markAsIncomplete() {
        this.completedAt = null;
    }
    
    public boolean isOverdue() {
        return task.getDueDate() != null && 
               task.getDueDate().isBefore(java.time.LocalDate.now()) && 
               !isCompleted();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Task getTask() {
        return task;
    }
    
    public void setTask(Task task) {
        this.task = task;
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
    
    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    
    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return "TaskAssignment{" +
                "id=" + id +
                ", assignedAt=" + assignedAt +
                ", completedAt=" + completedAt +
                ", isCompleted=" + isCompleted() +
                '}';
    }
}

