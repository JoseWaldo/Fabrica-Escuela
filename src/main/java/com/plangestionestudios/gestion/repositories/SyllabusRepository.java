package com.plangestionestudios.gestion.repositories;

import com.plangestionestudios.gestion.entities.EmphasisLine;
import com.plangestionestudios.gestion.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SyllabusRepository extends JpaRepository<Syllabus, Integer> {
    List<Syllabus> findByIdSyllabus(String idSyllabus);
}
