package com.example.travel.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    public Country(Long id, String country_name, int population, List<City> cities, Set<Language> languages) {
        this.id = id;
        this.country_name = country_name;
        this.population = population;
        this.cities = cities;
        this.languages = languages;
    }

    public Country() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name",
            length = 50,
            nullable = false)
    private String country_name;

    @Column(name = "population")
    private int population;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @ManyToMany
    @JoinTable(name = "country_language",
               joinColumns = @JoinColumn(name = "country_id"),
               inverseJoinColumns = @JoinColumn(name = "language_id"))

    private Set<Language> languages = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
