package com.example.travel.service;


import com.example.travel.entity.City;
import com.example.travel.entity.Country;
import com.example.travel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(long id) {
        Optional<City> result = cityRepository.findById(id);
        if (result.isPresent()) {
            return result.get();  // Eğer ülke bulunursa, bulunan ülkeyi döndür
        } else {
            throw new RuntimeException("ID ile şehir bulunamadı: " + id);  // Veya bulunamazsa bu durumu nasıl ele almak istediğinize bağlı olarak işleyin
        }
    }

    public long save(City city) {
        City save = cityRepository.save(city);
        return save.getId();
    }

    public void deleteById(long id) { cityRepository.deleteById(id);

    }

}

