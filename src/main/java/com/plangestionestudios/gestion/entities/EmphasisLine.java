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
@Table(name = "linea_de_enfasis")

public class EmphasisLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idEmphasisLine;
    @Column(name = "nombre_linea_enfasis", nullable = false)
    private String nameEmphasisLine;
    @Column(name = "tipo_linea_enfasis", nullable = false, unique = true)
    private String typeEmphasisLine;
    @Column(name = "descripcion_linea_enfasis", nullable = false)
    private String description;
    @Column(name = "total_creditos_linea_enfasis", nullable = false)
    private String totalCredits;
    @Column(name = "creditos_obligatorios_linea_enfasis", nullable = false)
    private int requiredCredits;
    @Column(name = "url_creacion_linea_enfasis")
    private String urlCreationEmphasisLine;
    /*@OneToMany (mappedBy = "course")
    private List<Course> courses;*/
}
