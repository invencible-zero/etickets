package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.model.Language;
import com.invencible_zero.etickets.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public List<Language> findAll() {
        log.info("Finding all languages");
        return languageRepository.findAll();
    }

    public Language findById(Integer id) {
        log.info("Finding language by id: {}", id);
        return languageRepository.findById(id).orElse(null);
    }

    public List<Language> findByName(String name) {
        log.info("Finding languages by name: {}", name);
        return languageRepository.findByName(name);
    }

    public Language save(Language language) {
        log.info("Saving language: {}", language);
        return languageRepository.save(language);
    }

    public void delete(Integer id) {
        log.info("Deleting language by id: {}", id);
        languageRepository.deleteById(id);
    }
}
