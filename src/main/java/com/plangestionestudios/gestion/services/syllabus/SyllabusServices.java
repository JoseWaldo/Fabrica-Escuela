package com.plangestionestudios.gestion.services.syllabus;

import com.plangestionestudios.gestion.entities.AcademicSubUnit;

import java.util.List;

public interface SyllabusServices {
    public boolean deleteSyllabus(int id);
    public List<AcademicSubUnit> getAllSyllabus();
    public AcademicSubUnit getSyllabusById(int id);
    public AcademicSubUnit updateSyllabus(int id, AcademicSubUnit academicSubUnit);
    public AcademicSubUnit createSyllabus(AcademicSubUnit academicSubUnit);
}
