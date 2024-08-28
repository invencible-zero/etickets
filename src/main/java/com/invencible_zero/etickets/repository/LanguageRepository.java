package com.invencible_zero.etickets.repository;

import com.invencible_zero.etickets.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    List<Language> findByName(String name);
}
