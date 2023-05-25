package com.plangestionestudios.gestion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idCourse;
    @Column(name = "nombre_curso",unique = true, nullable = false)
    private String nameCourse;
    @Column(name = "tipo_curso", nullable = false)
    private String typeCourse;
    @Column(name = "modalidad_curso", nullable = false)
    private String modalityCourse;
    @Column(name = "num_creditos_curso", precision = 3)
    private int numCreditsCourse;
    @Column(name = "es_validable_curso", nullable = false)
    private boolean isValidableCourse;
    @Column(name = "es_obligatorio_curso", nullable = false)
    private boolean isRequiredCourse;
    @Column(name = "es_habilitable_curso", nullable = false)
    private boolean isEnablableCourse;
}
