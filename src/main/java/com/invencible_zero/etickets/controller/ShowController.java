package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.service.ShowService;
import com.invencible_zero.etickets.model.Show;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> shows = showService.findAll();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Integer id) {
        Show show = showService.findById(id);
        if (show != null) {
            return new ResponseEntity<>(show, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show createdShow = showService.save(show);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Integer id, @RequestBody Show showDetails) {
        Show show = showService.findById(id);
        if (show != null) {
            show.setScreen(showDetails.getScreen());
            show.setMovie(showDetails.getMovie());
            show.setShowTime(showDetails.getShowTime());
            Show updatedShow = showService.save(show);
            return new ResponseEntity<>(updatedShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShow(@PathVariable Integer id) {
        Show show = showService.findById(id);
        if (show != null) {
            showService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
