package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.ScreenRepository;
import com.invencible_zero.etickets.model.Screen;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;

    public List<Screen> findAll() {
        log.info("Finding all screens");
        return screenRepository.findAll();
    }

    public Screen findById(Integer id) {
        log.info("Finding screen by id: {}", id);
        return screenRepository.findById(id).orElse(null);
    }


    public Screen save(Screen screen) {
        log.info("Saving Screen: {}", screen);
        return screenRepository.save(screen);
    }

    public void delete(Integer id) {
        log.info("Deleting Screen by id: {}", id);
        screenRepository.deleteById(id);
    }
}
