package com.plangestionestudios.gestion;

import com.plangestionestudios.gestion.controllers.AcademicUnitController;
import com.plangestionestudios.gestion.entities.AcademicUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AcademicUnitControllerTest {

    @Autowired
    private AcademicUnitController academicUnitController;

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
    }

    @Test
    void testDeleteAcademicUnit() {

        ResponseEntity<HttpStatus> response = academicUnitController.deleteBloque(-5);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        academicUnitController.createAcademicUnits(academicUnit);

        response = academicUnitController.deleteBloque(academicUnit.getIdAcademicUnit());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    @Test
    void testGetAllAcademicUnits() {
        assertEquals(HttpStatus.OK, academicUnitController.getAllAcademicUnits().getStatusCode());
    }
    @Test
    void testGetAcademicUnitById() {

        ResponseEntity<AcademicUnit> response= academicUnitController.getAcademicUnitById(-5);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        academicUnitController.createAcademicUnits(academicUnit);
        response = academicUnitController.getAcademicUnitById(academicUnit.getIdAcademicUnit());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        academicUnitController.deleteBloque(academicUnit.getIdAcademicUnit());
    }
    @Test
    void testCreateAcademicUnit() {
        AcademicUnit academicUnitEmpty = new AcademicUnit();

        assertEquals(HttpStatus.BAD_REQUEST, academicUnitController.createAcademicUnits(academicUnitEmpty).getStatusCode());

        assertEquals(HttpStatus.CREATED, academicUnitController.createAcademicUnits(academicUnit).getStatusCode());
        academicUnitController.deleteBloque(academicUnit.getIdAcademicUnit());
    }
}
