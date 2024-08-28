package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.MovieRepository;
import com.invencible_zero.etickets.model.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> findAll() {
        log.info("Finding all movies");
        return movieRepository.findAll();
    }

    public Movie findById(Integer id) {
        log.info("Finding movie by id: {}", id);
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> findByTitle(String title) {
        log.info("Finding movies by title: {}", title);
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findByGenreId(Integer genreId) {
        log.info("Finding movies by genre id: {}", genreId);
        return movieRepository.findByGenreId(genreId);
    }

    public List<Movie> findByLanguageId(Integer languageId) {
        log.info("Finding movies by language id: {}", languageId);
        return movieRepository.findByLanguageId(languageId);
    }

    public Movie saveMovie(Movie movie) {
        log.info("Saving movie: {}", movie);
        return movieRepository.save(movie);  // Persist the movie object
    }

    public void deleteById(Integer id) {
        log.info("Deleting movie with id: {}", id);
        movieRepository.deleteById(id);  // Delete by ID
    }
}
