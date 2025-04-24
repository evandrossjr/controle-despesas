package com.evandro.financeiro.service;

import com.evandro.financeiro.entity.CreditCard;
import com.evandro.financeiro.repository.CreditCardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> findAll(){
        return creditCardRepository.findAll();
    }

    public CreditCard findById(Long id){
        Optional<CreditCard> obj = creditCardRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceAccessException("Cartão não encontrado"));
    }

    public CreditCard insert(CreditCard obj){
        return creditCardRepository.save(obj);
    }

    public void delete(Long id){
        creditCardRepository.deleteById(id);
    }

    public CreditCard update(Long id, CreditCard obj){
        try{
            CreditCard entity = creditCardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CreditCard not found!"));
            updateData(entity, obj);
            return creditCardRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error to update CreditCard: " + e.getMessage(), e);
        }
    }

    private void updateData(CreditCard entity, CreditCard obj) {
        entity.setName(obj.getName());
        entity.setCreditLimit(obj.getCreditLimit());
        entity.setClosingDay(obj.getClosingDay());
        entity.setDueDay(obj.getDueDay());
    }
}


