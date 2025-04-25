package com.evandro.financeiro.service;

import com.evandro.financeiro.entity.Expense;
import com.evandro.financeiro.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> findAll(){
        return expenseRepository.findAll();
    }

    public Expense findById(Long id){
        Optional<Expense> obj = expenseRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceAccessException("Expense Not Found!"));
    }

    public Expense insert(Expense obj){
        return expenseRepository.save(obj);
    }

    public void delete(Long id){
        expenseRepository.deleteById(id);
    }

    public Expense update(Long id, Expense obj){
        try{
            Expense entity = expenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found!"));
            updateData(entity, obj);
            return expenseRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error to update Expense: " + e.getMessage(), e);
        }
    }

    private void updateData(Expense entity, Expense obj) {
        entity.setName(obj.getName());
        entity.setAmount(obj.getAmount());
        entity.setPaid(obj.isPaid());
        entity.setInstallmentNumber(obj.getInstallmentNumber());
        entity.setCategory(obj.getCategory());
        entity.setPaymentMethod(obj.getPaymentMethod());
        entity.setDueDate(obj.getDueDate());
        entity.setNote(obj.getNote());

    }
}

}
