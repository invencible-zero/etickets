package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.model.Theatre;
import com.invencible_zero.etickets.service.TheatreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheaters() {
        List<Theatre> theaters = theatreService.findAll();
        return new ResponseEntity<>(theaters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheaterById(@PathVariable Integer id) {
        Theatre theater = theatreService.findById(id);
        if (theater != null) {
            return new ResponseEntity<>(theater, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Theatre> createTheater(@RequestBody Theatre theater) {
        Theatre createdTheater = theatreService.save(theater);
        return new ResponseEntity<>(createdTheater, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheater(@PathVariable Integer id, @RequestBody Theatre theaterDetails) {
        Theatre theater = theatreService.findById(id);
        if (theater != null) {
            theater.setName(theaterDetails.getName());
            theater.setCity(theaterDetails.getCity());
            theater.setPartner(theaterDetails.getPartner());
            Theatre updatedTheater = theatreService.save(theater);
            return new ResponseEntity<>(updatedTheater, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTheater(@PathVariable Integer id) {
        Theatre theater = theatreService.findById(id);
        if (theater != null) {
            theatreService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
