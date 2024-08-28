package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.service.MovieService;
import com.invencible_zero.etickets.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")

@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // **Create (POST)**
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Indicate successful creation
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    // **Read (GET)**
    @GetMapping
    public List<Movie> findAllMovies() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findMovieById(@PathVariable Integer id) {
        return movieService.findById(id);
    }

    @GetMapping("/title/{title}")
    public List<Movie> findMoviesByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> findMoviesByGenreId(@PathVariable Integer genreId) {
        return movieService.findByGenreId(genreId);
    }

    @GetMapping("/language/{languageId}")
    public List<Movie> findMoviesByLanguageId(@PathVariable Integer languageId) {
        return movieService.findByLanguageId(languageId);
    }

    // **Update (PUT)**
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        movie.setId(id); // Ensure ID matches the path variable
        return movieService.saveMovie(movie);
    }

    // **Delete (DELETE)**
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Indicate successful deletion without content
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteById(id);
    }
}
