package com.evandro.financeiro.entity;


import com.evandro.financeiro.entity.enums.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name="EXPENSE")
public class Expense extends AbstractEntity<Long>{

    @Column(name="name", nullable = false, length = 15)
    private String name;
    private BigDecimal amount;
    private boolean paid = false;
    private int installmentNumber;

    @ManyToOne
    @JoinColumn(name="id_category_fk")
    private Category category;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // DINHEIRO, CARTAO, DEBITO

    private LocalDate dueDate;
    private String note;

    public Expense(){}


    public Expense(String name, BigDecimal amount, boolean paid, int installmentNumber, Category category, PaymentMethod paymentMethod, LocalDate dueDate, String note) {
        this.name = name;
        this.amount = amount;
        this.paid = paid;
        this.installmentNumber = installmentNumber;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
        this.note = note;
    }

    public Expense(Long id, String name, BigDecimal amount, boolean paid, int installmentNumber, Category category, PaymentMethod paymentMethod, LocalDate dueDate, String note) {
        super(id);
        this.name = name;
        this.amount = amount;
        this.paid = paid;
        this.installmentNumber = installmentNumber;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
