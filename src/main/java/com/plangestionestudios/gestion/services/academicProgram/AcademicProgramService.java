package com.plangestionestudios.gestion.services.academicProgram;

import com.plangestionestudios.gestion.entities.AcademicProgram;

import java.util.List;

public interface AcademicProgramService {
    public boolean deleteAcademicProgram(int id);
    public AcademicProgram getAcademicProgramById(int id);
    public List<AcademicProgram> getAllAcademicProgram();
    /*

    public AcademicUnit updateAcademicUnit(int id, AcademicUnit academicUnit);
    public AcademicUnit createAcademicUnit(AcademicUnit academicUnit);
     */
}
