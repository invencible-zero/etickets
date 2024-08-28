package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    List<Partner> findByName(String name);
}
