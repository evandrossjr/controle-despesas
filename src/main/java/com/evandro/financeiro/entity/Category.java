package com.evandro.financeiro.entity;


import jakarta.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name="CATEGORY")
public class Category extends AbstractEntity<Long>{

    @Column(name="name", nullable = false, unique = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    public Category(){}

    public Category(String name, List<Expense> expenses) {
        this.name = name;
        this.expenses = expenses;
    }

    public Category(Long id, String name, List<Expense> expenses) {
        super(id);
        this.name = name;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
