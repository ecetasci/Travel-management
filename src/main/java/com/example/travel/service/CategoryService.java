package com.example.travel.service;


import com.example.travel.entity.Category;
import com.example.travel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Transactional
    public Long save(Category category) {
        Category save = categoryRepository.save(category);
        return save.getId();
    }

    @Transactional
    public void deleteById(long id) {
        categoryRepository.deleteWithId(id);
    }

}
