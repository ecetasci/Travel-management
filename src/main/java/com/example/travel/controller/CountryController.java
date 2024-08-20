package com.example.travel.controller;


import com.example.travel.entity.Country;
import com.example.travel.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/list")
    public ResponseEntity<List<Country>> findAll() {
        List<Country> countries = countryService.findAll();
        return ResponseEntity.ok(countries);
    }

    @PostMapping("save")
    public ResponseEntity<Long> save(@RequestBody Country country) {
        Long save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<Country> findById(@PathVariable long id) {
        Country country = countryService.findById(id);
        return ResponseEntity.ok(country);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}



