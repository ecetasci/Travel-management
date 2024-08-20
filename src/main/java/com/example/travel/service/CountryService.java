package com.example.travel.service;


import com.example.travel.entity.Country;
import com.example.travel.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }



    public Country findById(long id) {
        Optional<Country> result = countryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();  // Eğer ülke bulunursa, bulunan ülkeyi döndür
        } else {
            throw new RuntimeException("ID ile ülke bulunamadı: " + id);  // Veya bulunamazsa bu durumu nasıl ele almak istediğinize bağlı olarak işleyin
        }
    }

    public long save(Country country) {
        Country save = countryRepository.save(country);
        return save.getId();
    }

          public void deleteById(long id) {
            countryRepository.deleteById(id); // Correctly calls the repository's deleteById method
        }


    }




