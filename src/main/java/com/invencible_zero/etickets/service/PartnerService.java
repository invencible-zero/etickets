package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.PartnerRepository;
import com.invencible_zero.etickets.model.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public List<Partner> findAll() {
        log.info("Finding all partners");
        return partnerRepository.findAll();
    }

    public Partner findById(Integer id) {
        log.info("Finding partner by id: {}", id);
        return partnerRepository.findById(id).orElse(null);
    }

    public List<Partner> findByName(String name) {
        log.info("Finding partners by name: {}", name);
        return partnerRepository.findByName(name);
    }

    public Partner save(Partner partner) {
        log.info("Saving Partner: {}", partner);
        return partnerRepository.save(partner);
    }

    public void delete(Integer id) {
        log.info("Deleting Partner by id: {}", id);
        partnerRepository.deleteById(id);
    }
}
