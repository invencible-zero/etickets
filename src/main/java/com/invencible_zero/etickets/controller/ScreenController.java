package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.model.Screen;
import com.invencible_zero.etickets.service.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens() {
        List<Screen> screens = screenService.findAll();
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Integer id) {
        Screen screen = screenService.findById(id);
        if (screen != null) {
            return new ResponseEntity<>(screen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
        Screen createdScreen = screenService.save(screen);
        return new ResponseEntity<>(createdScreen, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable Integer id, @RequestBody Screen screenDetails) {
        Screen screen = screenService.findById(id);
        if (screen != null) {
            screen.setTheatre(screenDetails.getTheatre());
            screen.setScreenNumber(screenDetails.getScreenNumber());
            Screen updatedScreen = screenService.save(screen);
            return new ResponseEntity<>(updatedScreen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteScreen(@PathVariable Integer id) {
        Screen screen = screenService.findById(id);
        if (screen != null) {
            screenService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
