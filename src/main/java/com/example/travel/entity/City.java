package com.example.travel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    public City(Long city_id, Country country, String city_name, int city_population, double crime_rate,
                Category category) {
        this.city_id = city_id;
        this.country = country;
        this.city_name = city_name;
        this.city_population = city_population;
        this.crime_rate = crime_rate;
        this.category = category;
    }

    public City() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id",
            nullable = false)
    private Long city_id;

    @ManyToOne
    @JoinColumn(name = "country_id",
                nullable = false)
    private Country country;

    @Column(name = "city_name",
            nullable = false)
    private String city_name;

    @Column(name = "city_population",
            nullable = false)
    private int city_population;

    @Column(name = "crime_rate")
    private double crime_rate;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "category_id",
                nullable = false)
    private Category category;

    public double getCrime_rate() {
        return crime_rate;
    }

    public void setCrime_rate(double crime_rate) {
        this.crime_rate = crime_rate;
    }

    public int getCity_population() {
        return city_population;
    }

    public void setCity_population(int city_population) {
        this.city_population = city_population;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public long getId() {
        return 0;
    }
}
