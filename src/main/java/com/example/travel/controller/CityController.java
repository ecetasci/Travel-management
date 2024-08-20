package com.example.travel.controller;


import com.example.travel.entity.City;
import com.example.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("save")
    public ResponseEntity<Long> save(@RequestBody City city) {
        Long save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<City> findById(@PathVariable long id) {
        City city = cityService.findById(id);
        return ResponseEntity.ok(city);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        cityService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
