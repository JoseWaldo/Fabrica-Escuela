package com.plangestionestudios.gestion.repositories;

import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.entities.EmphasisLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EmphasisLineRepository extends JpaRepository<EmphasisLine, Integer> {

    List<EmphasisLine> findByIdEmphasisLine(String idEmphasisLine);

}
