package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.services.academicUnit.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/academicUnit")
@RestController
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBloque(@PathVariable("id") int id) {
        boolean wasDeleteAcademicUnit = academicUnitService.deleteAcademicUnit(id);
        if(wasDeleteAcademicUnit) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicUnit> updateAcademicUnitById(@PathVariable("id") int id, @RequestBody AcademicUnit academicUnit) {
        AcademicUnit academicUnitUpdated = this.academicUnitService.updateAcademicUnit(id, academicUnit);
        if(academicUnitUpdated != null) return new ResponseEntity<>(academicUnitUpdated, HttpStatus.OK);
        return new ResponseEntity<>(academicUnitUpdated, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AcademicUnit>> getAllAcademicUnits() {
        List<AcademicUnit> academicUnitList = academicUnitService.getAllAcademicUnits();
        return new ResponseEntity<>(academicUnitList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicUnit> getAcademicUnitById(@PathVariable("id") int id) {
        AcademicUnit academicUnit = academicUnitService.getAcademicUnitById(id);
        if(academicUnit != null) return new ResponseEntity<>(academicUnit, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<AcademicUnit> createAcademicUnits(@RequestBody AcademicUnit academicUnit) {
        AcademicUnit academicUnitCreated = academicUnitService.createAcademicUnit(academicUnit);
        if(academicUnitCreated != null) {
            return new ResponseEntity<>(academicUnitCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(academicUnitCreated, HttpStatus.BAD_REQUEST);
    }

}
