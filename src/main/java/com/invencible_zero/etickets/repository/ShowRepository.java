package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Timestamp;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    List<Show> findByShowTime(Timestamp showTime);
    List<Show> findByMovieId(Integer movieId);
    List<Show> findByScreenId(Integer screenId);
}
