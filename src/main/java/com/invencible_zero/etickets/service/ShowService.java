package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.ShowRepository;
import com.invencible_zero.etickets.model.Show;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;

    public List<Show> findAll() {
        log.info("Finding all shows");
        return showRepository.findAll();
    }

    public Show findById(Integer id) {
        log.info("Finding show by id: {}", id);
        return showRepository.findById(id).orElse(null);
    }

    public List<Show> findByShowTime(Timestamp showTime) {
        log.info("Finding shows by show time: {}", showTime);
        return showRepository.findByShowTime(showTime);
    }

    public List<Show> findByMovieId(Integer movieId) {
        log.info("Finding shows by movie id: {}", movieId);
        return showRepository.findByMovieId(movieId);
    }

    public List<Show> findByScreenId(Integer screenId) {
        log.info("Finding shows by screen id: {}", screenId);
        return showRepository.findByScreenId(screenId);
    }


    public Show save(Show show) {
        log.info("Saving Show: {}", show);
        return showRepository.save(show);
    }

    public void delete(Integer id) {
        log.info("Deleting Show by id: {}", id);
        showRepository.deleteById(id);
    }
}
