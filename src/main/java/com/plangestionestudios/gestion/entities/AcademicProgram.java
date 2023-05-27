package com.plangestionestudios.gestion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "programa_academico")
public class AcademicProgram {
    @Id //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idAcademicProgram;
    @Column(name = "nombre_programa_academico", nullable = false)
    private String nameAcademicProgram;
    @Column(name = "codigo_programa_academico", nullable = false, unique = true)
    private String codeAcademicProgram;
    @Column(name = "tipo_programa_academico", nullable = false)
    private String typeAcademicProgram;
    @Column(name = "nombre_encargado", nullable = false)
    private String managerName;
    @Column(name = "descripcion_programa_academico", nullable = false)
    private String description;
    @Column(name = "modalidad_programa_academico", nullable = false)
    private String underthesystemAcademicProgram;
    @Column(name = "codigo_SNIESS", nullable = false)
    private String SNIESSCode;
    @Column(name = "contactos_ayuda")
    private String supportcontactsAcademicProgram;
    @Column(name = "plan_de_estudios")
    private String curriculumAcademicProgram;
    /*@ManyToOne
    @JoinColumn(name = "id_academic_subunit", nullable = false)
    @JsonBackReference
    private AcademicSubUnit academicSubUnit;*/
}
