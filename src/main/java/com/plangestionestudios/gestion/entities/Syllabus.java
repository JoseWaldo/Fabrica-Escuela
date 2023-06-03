package com.plangestionestudios.gestion.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "plan_de_estudios")
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idSyllabus;
    @Column(name = "nombre_plan_estudios",unique = true, nullable = false)
    private String nameCourse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_academic_program", nullable = false)
    @JsonBackReference
    private AcademicUnit academicUnit;
}
