package com.plangestionestudios.gestion.repositories;

import com.plangestionestudios.gestion.entities.AcademicProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, Integer> {
    List<AcademicProgram> findByCodeAcademicProgram(String codeAcademicProgram);
}
