package com.plangestionestudios.gestion;

import com.plangestionestudios.gestion.controllers.AcademicUnitController;
import com.plangestionestudios.gestion.entities.AcademicUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.plangestionestudios.gestion.entities.AcademicSubUnit;
import com.plangestionestudios.gestion.controllers.AcademicSubUnitController;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class AcademicSubUnitControllerTest {
    @Autowired
    private AcademicSubUnitController academicSubUnitController;
    @Autowired
    private AcademicUnitController academicUnitController;
    static AcademicSubUnit subAcademicUnit = new AcademicSubUnit();
    static AcademicUnit academicUnit = new AcademicUnit();
    @BeforeAll
    public static void setUp() {
        academicUnit.setNameAcademicUnit("name");
        academicUnit.setCodeAcademicUnit("code");
        academicUnit.setTypeAcademicUnit("facultad");
        academicUnit.setDeanName("dean");
        academicUnit.setDescription("description");
        academicUnit.setUbicationAcademicUnit("ubication");
        academicUnit.setCostCenterCode("costCenter");

        subAcademicUnit.setCodeAcademicSubUnit("code");
        subAcademicUnit.setNameAcademicSubUnit("name");
        subAcademicUnit.setTypeAcademicSubUnit("departamento");
        subAcademicUnit.setHeadName("head");
        subAcademicUnit.setDescription("description");
    }

    @Test
    void testGetAllAcademicSubUnits() {
        assertEquals(HttpStatus.OK, academicSubUnitController.getAllAcademicSubUnits().getStatusCode());
    }

    @Test
    void testGetAcademicSubUnitById() {
        ResponseEntity<AcademicSubUnit> response = academicSubUnitController.getAcademicSubUnitById(-1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        academicUnitController.createAcademicUnits(academicUnit);
        subAcademicUnit.setAcademicUnit(academicUnit);

        academicSubUnitController.createAcademicSubUnits(subAcademicUnit);

        response = academicSubUnitController.getAcademicSubUnitById(subAcademicUnit.getIdAcademicSubUnit());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        academicUnitController.deleteBloque(academicUnit.getIdAcademicUnit());
        academicSubUnitController.deleteAcademicSubUnit(subAcademicUnit.getIdAcademicSubUnit());
    }

    @Test
    void testCreateAcademicSubUnits() {
        ResponseEntity<AcademicSubUnit> response = academicSubUnitController.createAcademicSubUnits(subAcademicUnit);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
