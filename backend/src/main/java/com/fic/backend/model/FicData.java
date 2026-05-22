package com.fic.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fic_data")
@Data
public class FicData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_fondo", length = 300)
    private String nombreFondo;

    @Column(name = "sociedad_gestora", length = 200)
    private String sociedadGestora;

    @Column(precision = 12, scale = 6)
    private BigDecimal rentabilidad;

    @Column(length = 50)
    private String periodo;

    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

    @Column(length = 100)
    private String fuente = "datos.gov.co";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}