package com.plangestionestudios.gestion.services.curriculumVersion;

import com.plangestionestudios.gestion.entities.CurriculumVersion;

import java.util.List;

public interface CurriculumVersionService {
    public boolean deleteCurriculumVersion(int id);
    public List<CurriculumVersion> getAllCurriculumVersion();
    public CurriculumVersion getByIdCurriculumVersion(int id);
    public CurriculumVersion updateCurriculumVersion(int id, CurriculumVersion curriculumVersion);
    public CurriculumVersion createCurriculumVersion(CurriculumVersion curriculumVersion);
}
