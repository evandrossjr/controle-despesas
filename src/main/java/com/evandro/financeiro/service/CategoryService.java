package com.evandro.financeiro.service;


import com.evandro.financeiro.entity.Category;
import com.evandro.financeiro.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(()-> new ResourceAccessException("Category Not Found!"));
    }

    public Category insert(Category obj){
        return categoryRepository.save(obj);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, Category obj){
        try{
            Category entity = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found!"));
            updateData(entity, obj);
            return categoryRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error to update Category: " + e.getMessage(), e);
        }
    }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }
}




