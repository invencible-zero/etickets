package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.TheatreRepository;
import com.invencible_zero.etickets.model.Theatre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheatreService {
    private final TheatreRepository theatreRepository;

    public List<Theatre> findAll() {
        log.info("Finding all theatres");
        return theatreRepository.findAll();
    }

    public Theatre findById(Integer id) {
        log.info("Finding theatre by id: {}", id);
        return theatreRepository.findById(id).orElse(null);
    }

    public List<Theatre> findByName(String name) {
        log.info("Finding theatres by name: {}", name);
        return theatreRepository.findByName(name);
    }

    public List<Theatre> findByCityId(Integer cityId) {
        log.info("Finding theatres by city id: {}", cityId);
        return theatreRepository.findByCityId(cityId);
    }

    public Theatre save(Theatre theatre) {
        log.info("Saving Theatre: {}", theatre);
        return theatreRepository.save(theatre);
    }

    public void delete(Integer id) {
        log.info("Deleting Theatre by id: {}", id);
        theatreRepository.deleteById(id);
    }
}
