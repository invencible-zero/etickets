package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.model.Offer;
import com.invencible_zero.etickets.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    public List<Offer> findAll() {
        log.info("Finding all offers");
        return offerRepository.findAll();
    }

    public Offer findById(Integer id) {
        log.info("Finding offer by id: {}", id);
        return offerRepository.findById(id).orElse(null);
    }

    public Offer save(Offer offer) {
        log.info("Saving offer: {}", offer);
        return offerRepository.save(offer);
    }

    public void delete(Integer id) {
        log.info("Deleting offer by id: {}", id);
        offerRepository.deleteById(id);
    }
}
