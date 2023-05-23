package com.plangestionestudios.gestion.services.academicProgram;

import com.plangestionestudios.gestion.entities.AcademicProgram;
import com.plangestionestudios.gestion.repositories.AcademicProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicProgramServiceImp implements AcademicProgramService {

    @Autowired
    private AcademicProgramRepository academicProgramRepository;

    @Override
    public boolean deleteAcademicProgram(int id) {
        AcademicProgram academicProgramFound = this.getAcademicProgramById(id);
        if(academicProgramFound != null) {
            academicProgramRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public AcademicProgram getAcademicProgramById(int id) {
        Optional<AcademicProgram> academicProgram = academicProgramRepository.findById(id);
        if(academicProgram.isPresent()) return academicProgram.get();
        return null;
    }

    @Override
    public List<AcademicProgram> getAllAcademicProgram() {
        List<AcademicProgram> academicProgramsList = academicProgramRepository.findAll();
        return academicProgramsList;
    }

    /*


    @Override
    public AcademicUnit updateAcademicUnit(int id, AcademicUnit academicUnit) {
        AcademicUnit foundAcademicUnit = this.getAcademicUnitById(id);
        if(foundAcademicUnit != null) {
            foundAcademicUnit.setDeanName(academicUnit.getDeanName());
            foundAcademicUnit.setDescription(academicUnit.getDescription());
            foundAcademicUnit.setNameAcademicUnit(academicUnit.getNameAcademicUnit());
            this.academicUnitRepository.save(foundAcademicUnit);
            return this.getAcademicUnitById(id);
        }
        return null;
    }

    @Override
    public AcademicUnit createAcademicUnit(AcademicUnit academicUnit) {
        if(!this.isCorrectInfoAU(academicUnit)) return null;

        String codeAU = academicUnit.getCodeAcademicUnit();
        List<AcademicUnit> academicUnitFound = academicUnitRepository.findByCodeAcademicUnit(codeAU);
        System.out.println(academicUnitFound);
        if(academicUnitFound.isEmpty()) {
            academicUnitRepository.save(academicUnit);
            return academicUnit;
        }
        return null;
    }

    private boolean isCorrectInfoAU(AcademicUnit academicUnit) {

        if(academicUnit == null) return false;

        String[] typesUA = {"facultad", "departamento", "instituto", "escuela", "corporación"};

        String nameAU = academicUnit.getNameAcademicUnit();
        String codeAU = academicUnit.getCodeAcademicUnit();
        String typeAU = academicUnit.getTypeAcademicUnit().toLowerCase();
        String deanAU = academicUnit.getDeanName();
        String descriptionAU = academicUnit.getDescription();
        String ubicationAU = academicUnit.getUbicationAcademicUnit();
        String codeCenterCodeAU = academicUnit.getCostCenterCode(); 

        if(nameAU == null || codeAU == null || typeAU == null || deanAU == null || descriptionAU == null || ubicationAU == null || codeCenterCodeAU == null ) return false;
        if(codeAU.length() == 0) return false;

        boolean isFoundTypeUA = Arrays.stream(typesUA).anyMatch(type -> type.equals(typeAU));
        if(!isFoundTypeUA) return false;

        return true;
    }
*/
}
