package com.example.travel.controller;


import com.example.travel.entity.Category;
import com.example.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Category category) {
        Long save = categoryService.save(category);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
