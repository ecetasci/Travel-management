package com.example.travel.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "category")
public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name",
            length = 50,
            nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<City> cities;

    public Category(Long id, String categoryName, List<City> cities) {
        this.id = id;
        this.categoryName = categoryName;
        this.cities = cities;
    }

    public Category() {
    }


    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
