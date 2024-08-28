package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.GenreRepository;
import com.invencible_zero.etickets.model.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> findAll() {
        log.info("Finding all genres");
        return genreRepository.findAll();
    }

    public Genre findById(Integer id) {
        log.info("Finding genre by id: {}", id);
        return genreRepository.findById(id).orElse(null);
    }

    public List<Genre> findByName(String name) {
        log.info("Finding genres by name: {}", name);
        return genreRepository.findByName(name);
    }

    public Genre save(Genre genre) {
        log.info("Saving genre: {}", genre);
        return genreRepository.save(genre);
    }

    public void delete(Integer id) {
        log.info("Deleting genre by id: {}", id);
        genreRepository.deleteById(id);
    }
}
