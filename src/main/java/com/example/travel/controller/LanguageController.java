package com.example.travel.controller;


import com.example.travel.entity.Language;
import com.example.travel.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("save")
    public ResponseEntity<Long> save(@RequestBody Language language) {
        Long save = languageService.save(language);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> findById(@PathVariable long id) {
        Language language = languageService.findById(id);
        return ResponseEntity.ok(language);
    }
}

