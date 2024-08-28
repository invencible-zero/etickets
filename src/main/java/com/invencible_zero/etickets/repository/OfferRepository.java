package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Timestamp;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findByTitle(String title);
    List<Offer> findByStartDate(Timestamp startDate);
    List<Offer> findByEndDate(Timestamp endDate);
    List<Offer> findByMovieId(Integer movieId);
    List<Offer> findByTheatreId(Integer theatreId);
}
