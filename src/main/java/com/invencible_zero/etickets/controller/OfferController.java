package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.model.Offer;
import com.invencible_zero.etickets.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.findAll();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Integer id) {
        Offer offer = offerService.findById(id);
        if (offer != null) {
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer createdOffer = offerService.save(offer);
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable Integer id, @RequestBody Offer offerDetails) {
        Offer offer = offerService.findById(id);
        if (offer != null) {
            offer.setDescription(offerDetails.getDescription());
            offer.setDiscountPercentage(offerDetails.getDiscountPercentage());
            Offer updatedOffer = offerService.save(offer);
            return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOffer(@PathVariable Integer id) {
        Offer offer = offerService.findById(id);
        if (offer != null) {
            offerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
