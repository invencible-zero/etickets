package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByName(String name);
    List<Theatre> findByCityId(Integer cityId);
}
