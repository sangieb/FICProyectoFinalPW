package com.fic.backend.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByEntityNameAndEntityPkOrderByChangedAtDesc(
            String entityName, Long entityPk);

    List<AuditLog> findByChangedByOrderByChangedAtDesc(String changedBy);

    List<AuditLog> findByActionOrderByChangedAtDesc(AuditAction action);

    @Query("SELECT a FROM AuditLog a WHERE a.changedAt BETWEEN :from AND :to ORDER BY a.changedAt DESC")
    List<AuditLog> findByDateRange(
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to);
}