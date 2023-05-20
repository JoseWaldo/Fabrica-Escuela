package com.plangestionestudios.gestion.services.academicSubUnit;

import com.plangestionestudios.gestion.entities.AcademicSubUnit;
import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.repositories.AcademicSubUnitRepository;
import com.plangestionestudios.gestion.services.academicUnit.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicSubUnitServiceImp implements AcademicSubUnitService{

    @Autowired
    private AcademicSubUnitRepository academicSubUnitRepository;

    @Autowired
    private AcademicUnitService academicUnitService;

    @Override
    public boolean deleteAcademicSubUnit(int id) {
        return false;
    }

    @Override
    public List<AcademicSubUnit> getAllAcademicSubUnits() {
        List<AcademicSubUnit> academicSubUnitList = this.academicSubUnitRepository.findAll();
        return academicSubUnitList;
    }

    @Override
    public AcademicSubUnit getAcademicSubUnitById(int id) {
        Optional<AcademicSubUnit> academicSubUnit = this.academicSubUnitRepository.findById(id);
        if(academicSubUnit.isPresent()) return academicSubUnit.get();
        return null;
    }

    @Override
    public AcademicSubUnit updateAcademicSubUnit(int id, AcademicSubUnit academicSubUnit) {

        if(!this.isCorrectUpdateInfoASU(academicSubUnit)) return null;

        AcademicSubUnit foundAcademicSubUnit = this.getAcademicSubUnitById(id);

        if(foundAcademicSubUnit != null){
            foundAcademicSubUnit.setNameAcademicSubUnit(academicSubUnit.getNameAcademicSubUnit());
            foundAcademicSubUnit.setHeadName(academicSubUnit.getHeadName());
            foundAcademicSubUnit.setTypeAcademicSubUnit(academicSubUnit.getTypeAcademicSubUnit());
            foundAcademicSubUnit.setDescription(academicSubUnit.getDescription());
            this.academicSubUnitRepository.save(foundAcademicSubUnit);
            return this.getAcademicSubUnitById(id);
        }
        return null;
    }

    @Override
    public AcademicSubUnit createAcademicSubUnit(AcademicSubUnit academicSubUnit) {

        if(!this.isCorrectInfoASU(academicSubUnit)) return null;

        int idAcademicUnit = academicSubUnit.getAcademicUnit().getIdAcademicUnit();
        AcademicUnit academicUnit = this.academicUnitService.getAcademicUnitById(idAcademicUnit);

        System.out.println(academicUnit);

        if(academicUnit == null) return null;

        String codeAcademicSubUnit = academicSubUnit.getCodeAcademicSubUnit();
        List<AcademicSubUnit> academicSubUnitFound = academicSubUnitRepository.findByCodeAcademicSubUnit(codeAcademicSubUnit);
        System.out.println(academicSubUnitFound);
        if(academicSubUnitFound.isEmpty()) {
            academicSubUnit.setAcademicUnit(academicUnit);
            this.academicSubUnitRepository.save(academicSubUnit);
            return academicSubUnit;
        }
        return null;
    }

    private boolean isCorrectInfoASU(AcademicSubUnit academicSubUnit) {

        if(academicSubUnit == null) return false;

        String codeASU = academicSubUnit.getCodeAcademicSubUnit();
        String nameASU = academicSubUnit.getNameAcademicSubUnit();
        String typeASU = academicSubUnit.getTypeAcademicSubUnit();
        String headASU = academicSubUnit.getHeadName();
        String descASU = academicSubUnit.getDescription();
        AcademicUnit academicUnitASU = academicSubUnit.getAcademicUnit();

        String[] typesASU = {"departamento", "instituto", "escuela"};

        if(codeASU == null || nameASU == null || typeASU == null || descASU == null || headASU == null || academicUnitASU == null) return false;
        if(codeASU.length() == 0) return false;

        boolean isFoundTypeASU = Arrays.stream(typesASU).anyMatch(type -> type.equals(typeASU.toLowerCase()));
        if(!isFoundTypeASU) return false;

        return true;
    }

    private boolean isCorrectUpdateInfoASU(AcademicSubUnit academicSubUnit) {
        if(academicSubUnit == null) return false;

        String nameASU = academicSubUnit.getNameAcademicSubUnit();
        String headNameASU = academicSubUnit.getHeadName();
        String typeASU = academicSubUnit.getTypeAcademicSubUnit();
        String descriptionASU = academicSubUnit.getDescription();

        String[] typesASU = {"departamento", "instituto", "escuela"};

        if(nameASU == null || headNameASU == null || typeASU == null || descriptionASU == null) return false;

        boolean isFoundTypeASU = Arrays.stream(typesASU).anyMatch(type -> type.equals(typeASU.toLowerCase()));
        if(!isFoundTypeASU) return false;

        return true;
    }

}
