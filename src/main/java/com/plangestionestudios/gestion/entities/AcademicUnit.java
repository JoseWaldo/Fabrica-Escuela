package com.plangestionestudios.gestion.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "unidad_academica")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idAcademicUnit;
    @Column(name = "nombre_unidad_academica", nullable = false)
    private String nameAcademicUnit;
    @Column(name = "codigo_unidad_academica", nullable = false, unique = true)
    private String codeAcademicUnit;
    @Column(name = "tipo_unidad_academica", nullable = false)
    private String typeAcademicUnit;
    @Column(name = "nombre_decano", nullable = false)
    private String deanName;
    @Column(name = "descripcion_unidad_academica", nullable = false)
    private String description;
    @Column(name = "ubicacion_unidad_academica", nullable = false)
    private String ubicationAcademicUnit;
    @Column(name = "codigo_centro_costos", nullable = false)
    private String costCenterCode;
    @Column(name = "url_creacion_unidad_academica")
    private String urlCreationAcademicUnit;
    @OneToMany (mappedBy = "academicUnit", fetch = FetchType.LAZY)
    private List<AcademicSubUnit> academicSubUnits;
}
