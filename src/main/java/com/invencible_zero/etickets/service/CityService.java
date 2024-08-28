package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.CityRepository;
import com.invencible_zero.etickets.model.City;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll() {
        log.info("Finding all cities");
        return cityRepository.findAll();
    }

    public City findById(Integer id) {
        log.info("Finding city by id: {}", id);
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> findByName(String name) {
        log.info("Finding cities by name: {}", name);
        return cityRepository.findByName(name);
    }

    public City save(City city) {
        log.info("Saving city: {}", city);
        return cityRepository.save(city);
    }

    public void delete(Integer id) {
        log.info("Deleting city by id: {}", id);
        cityRepository.deleteById(id);
    }
}
