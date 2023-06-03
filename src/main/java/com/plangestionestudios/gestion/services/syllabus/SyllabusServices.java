package com.plangestionestudios.gestion.services.syllabus;

import com.plangestionestudios.gestion.entities.AcademicSubUnit;
import com.plangestionestudios.gestion.entities.Syllabus;

import java.util.List;

public interface SyllabusServices {
    public boolean deleteSyllabus(int id);
    public List<Syllabus> getAllSyllabus();
    public Syllabus getSyllabusById(int id);
    public Syllabus updateSyllabus(int id,  Syllabus syllabus);
    public Syllabus createSyllabus(Syllabus syllabus);
}
