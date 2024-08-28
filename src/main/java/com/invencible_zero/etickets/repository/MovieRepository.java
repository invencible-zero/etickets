package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitle(String title);
    List<Movie> findByGenreId(Integer genreId);
    List<Movie> findByLanguageId(Integer languageId);
}
