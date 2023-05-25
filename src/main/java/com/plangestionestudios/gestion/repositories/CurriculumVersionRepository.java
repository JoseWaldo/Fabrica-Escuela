package com.plangestionestudios.gestion.repositories;

import com.plangestionestudios.gestion.entities.CurriculumVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumVersionRepository extends JpaRepository<CurriculumVersion, Integer> {
    List<CurriculumVersion> findByNumCurriculumVersion(int numCurriculumVersion);
}
