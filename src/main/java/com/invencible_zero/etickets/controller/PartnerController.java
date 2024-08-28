package com.invencible_zero.etickets.controller;

import com.invencible_zero.etickets.service.PartnerService;
import com.invencible_zero.etickets.model.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/partners")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners() {
        List<Partner> partners = partnerService.findAll();
        return new ResponseEntity<>(partners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable Integer id) {
        Partner partner = partnerService.findById(id);
        if (partner != null) {
            return new ResponseEntity<>(partner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
        Partner createdPartner = partnerService.save(partner);
        return new ResponseEntity<>(createdPartner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Integer id, @RequestBody Partner partnerDetails) {
        Partner partner = partnerService.findById(id);
        if (partner != null) {
            partner.setName(partnerDetails.getName());
            partner.setContactEmail(partnerDetails.getContactEmail());
            Partner updatedPartner = partnerService.save(partner);
            return new ResponseEntity<>(updatedPartner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePartner(@PathVariable Integer id) {
        Partner partner = partnerService.findById(id);
        if (partner != null) {
            partnerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
