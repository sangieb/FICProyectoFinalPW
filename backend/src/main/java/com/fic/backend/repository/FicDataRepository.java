package com.fic.backend.repository;

import com.fic.backend.model.FicData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FicDataRepository extends JpaRepository<FicData, Long> {
    List<FicData> findBySociedadGestoraContainingIgnoreCase(String gestora);
    List<FicData> findByPeriodo(String periodo);
}