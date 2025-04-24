package com.evandro.financeiro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@SuppressWarnings("serial")
@Entity
@Table(name="CREDITCARD")
public class CreditCard extends AbstractEntity<Long>{

    @Column(name="name", nullable = false, unique = true, length = 15)
    private String name;
    private BigDecimal creditLimit;
    private int dueDay;
    private int closingDay;

    public CreditCard(){}

    public CreditCard(String name, BigDecimal creditLimit, int dueDay, int closingDay) {
        this.name = name;
        
        this.creditLimit = creditLimit;
        this.dueDay = dueDay;
        this.closingDay = closingDay;
    }

    public CreditCard(Long id, String name, BigDecimal creditLimit, int dueDay, int closingDay) {
        super(id);
        this.name = name;
        this.creditLimit = creditLimit;
        this.dueDay = dueDay;
        this.closingDay = closingDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public int getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(int closingDay) {
        this.closingDay = closingDay;
    }
}
