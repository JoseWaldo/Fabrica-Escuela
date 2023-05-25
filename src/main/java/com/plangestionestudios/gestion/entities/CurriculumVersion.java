package com.plangestionestudios.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "version_plan_de_estudios")
public class CurriculumVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idCurriculumVersion;
    @Column(unique = true, nullable = false, precision = 2)
    private int numCurriculumVersion;
    @Column(nullable = true)
    private int totalCreditsCurriculumVersion;
}
