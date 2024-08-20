package com.example.travel.service;


import com.example.travel.entity.Language;
import com.example.travel.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Language findById(long id) {
        return null;
    }

    public long save(Language language) {
        Language save = languageRepository.save(language);
        return save.getId();
    }

    public void deleteById(long id) {
    }

}
