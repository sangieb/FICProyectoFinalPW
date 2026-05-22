package com.fic.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "reporte")
@Data
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false, length = 10)
    private String formato; // PDF o EXCEL

    @ManyToOne
    @JoinColumn(name = "generado_por")
    private Usuario generadoPor;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt = LocalDateTime.now();

    @Column(name = "filtros_json", columnDefinition = "TEXT")
    private String filtrosJson;
}