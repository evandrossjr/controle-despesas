package com.evandro.financeiro.entity;


import com.evandro.financeiro.entity.enums.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name="EXPENSE")
public class Expense extends AbstractEntity<Long>{

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

    public Expense(BigDecimal amount, boolean paid, int installmentNumber, Category category, PaymentMethod paymentMethod, LocalDate dueDate, String note) {
        this.amount = amount;
        this.paid = paid;
        this.installmentNumber = installmentNumber;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
        this.note = note;
    }

    public Expense(Long id, BigDecimal amount, boolean paid, int installmentNumber, Category category, PaymentMethod paymentMethod, LocalDate dueDate, String note) {
        super(id);
        this.amount = amount;
        this.paid = paid;
        this.installmentNumber = installmentNumber;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.dueDate = dueDate;
        this.note = note;
    }
}
