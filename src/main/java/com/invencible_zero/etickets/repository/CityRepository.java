package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByName(String name);
}
