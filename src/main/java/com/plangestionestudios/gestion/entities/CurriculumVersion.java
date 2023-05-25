package com.plangestionestudios.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "version_plan_de_estudios")
public class CurriculumVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idCurriculumVersion;
    @Column(name = "num_version_curriculum",unique = true, nullable = false, precision = 2)
    private int numCurriculumVersion;
    @Column(name = "total_creditos_version",nullable = true)
    private int totalCreditsCurriculumVersion;
}
