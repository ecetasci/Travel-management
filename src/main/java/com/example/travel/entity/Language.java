package com.example.travel.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    public Language(Long languageId, String languageName, Set<Country> countries) {
        this.id = languageId;
        this.languageName = languageName;
        this.countries = countries;
    }

    public Language() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId",
            nullable = false)
    private Long id;


    @Column(name = "languageName",
            length = 50,
            nullable = false)
    private String languageName;

    @ManyToMany(mappedBy = "languages")
    private Set<Country> countries = new HashSet<>();

    public String getLanguageName() {
        return languageName;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Long getLanguageId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLanguageId(Long languageId) {
        this.id = languageId;
    }

    public long getId() {
        return id;
    }
}
