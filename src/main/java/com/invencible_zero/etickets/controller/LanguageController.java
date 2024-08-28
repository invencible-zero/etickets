package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.model.Language;
import com.invencible_zero.etickets.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = languageService.findAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Integer id) {
        Language language = languageService.findById(id);
        if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Language>> getLanguagesByName(@RequestParam String name) {
        List<Language> languages = languageService.findByName(name);
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language createdLanguage = languageService.save(language);
        return new ResponseEntity<>(createdLanguage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Integer id, @RequestBody Language languageDetails) {
        Language language = languageService.findById(id);
        if (language != null) {
            language.setName(languageDetails.getName());
            Language updatedLanguage = languageService.save(language);
            return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLanguage(@PathVariable Integer id) {
        Language language = languageService.findById(id);
        if (language != null) {
            languageService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
