package com.plangestionestudios.gestion.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sub_unidad_academica")
public class AcademicSubUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idAcademicSubUnit;
    @Column(name = "codigo_sub_unidad_academica", nullable = false, unique = true)
    private String codeAcademicSubUnit;
    @Column(name = "nombre_sub_unidad_academica", nullable = false)
    private String nameAcademicSubUnit;
    @Column(name = "tipo_sub_unidad_academica", nullable = false)
    private String typeAcademicSubUnit;
    @Column(name = "nombre_jefe", nullable = false)
    private String headName;
    @Column(name = "descripcion_sub_unidad_academica", nullable = false)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_academic_unit", nullable = false)
    @JsonBackReference
    private AcademicUnit academicUnit;

    public Integer getAcademicUnitId() {
        if(academicUnit != null) {
            return academicUnit.getIdAcademicUnit();
        }
        return null;
    }
}
