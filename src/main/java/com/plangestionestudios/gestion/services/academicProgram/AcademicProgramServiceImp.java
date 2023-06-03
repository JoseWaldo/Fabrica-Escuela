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

    @Override
    public AcademicProgram updateAcademicProgram(int id, AcademicProgram academicProgram) {
        AcademicProgram foundAcademicProgram = this.getAcademicProgramById(id);
        if(foundAcademicProgram != null) {
            foundAcademicProgram.setManagerName(academicProgram.getManagerName());
            foundAcademicProgram.setDescription(academicProgram.getDescription());
            foundAcademicProgram.setNameAcademicProgram(academicProgram.getNameAcademicProgram());
            this.academicProgramRepository.save(foundAcademicProgram);
            return this.getAcademicProgramById(id);
        }
        return null;
    }

    @Override
    public AcademicProgram createAcademicProgram(AcademicProgram academicProgram) {
        if(!this.isCorrectInfoAP(academicProgram)) return null;

        String codeAP = academicProgram.getCodeAcademicProgram();
        List<AcademicProgram> academicProgramFound = academicProgramRepository.findByCodeAcademicProgram(codeAP);
        if(academicProgramFound.isEmpty()) {
            academicProgramRepository.save(academicProgram);
            return academicProgram;
        }
        return null;
    }

    private boolean isCorrectInfoAP(AcademicProgram academicProgram) {

        if(academicProgram == null) return false;

        String[] typesAP = {"Tecnología", "Técnica", "Licenciatura", "Pregrado", "Posgrado", "Especialidad", "Maestría", "Doctorado"};
        String[] underthesystemAcademicProgramsAP = { "Presencial", "Virtual", "Mixta"};

        String nameAP = academicProgram.getNameAcademicProgram();
        String codeAP = academicProgram.getCodeAcademicProgram();
        String typeAP = academicProgram.getTypeAcademicProgram().toLowerCase();
        String managerAP = academicProgram.getManagerName();
        String descriptionAP = academicProgram.getDescription();
        String underthesystemAcademicProgramAP = academicProgram.getUnderthesystemAcademicProgram();
        String SNIESSCodeAP = academicProgram.getSNIESSCode();
        String contactosAyudaAcademicProgrameAP = academicProgram.getSupportcontactsAcademicProgram();
        String planEstudiosAcademicProgramAP = academicProgram.getCurriculumAcademicProgram();

        if(nameAP == null || codeAP == null || typeAP == null || managerAP == null || descriptionAP == null || underthesystemAcademicProgramAP == null || SNIESSCodeAP == null || contactosAyudaAcademicProgrameAP == null || planEstudiosAcademicProgramAP == null ) return false;
        if(codeAP.length() == 0 && SNIESSCodeAP.length() == 0 ) return false;

        boolean isFoundTypeandunderthesystemAcademicProgramAP = Arrays.stream(typesAP).anyMatch(type -> type.equals(typeAP)) && Arrays.stream(underthesystemAcademicProgramsAP).anyMatch(type -> type.equals(underthesystemAcademicProgramAP));
        if(!isFoundTypeandunderthesystemAcademicProgramAP) return false;

        return true;
    }

}
