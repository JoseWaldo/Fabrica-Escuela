package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.AcademicSubUnit;
import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.services.academicSubUnit.AcademicSubUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/academicSubUnit")

public class AcademicSubUnitController {

    @Autowired
    private AcademicSubUnitService academicSubUnitService;

    @GetMapping("/all")
    public ResponseEntity<List<AcademicSubUnit>> getAllAcademicSubUnits() {
        List<AcademicSubUnit> academicSubUnitList = this.academicSubUnitService.getAllAcademicSubUnits();
        return new ResponseEntity<>(academicSubUnitList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicSubUnit> getAcademicSubUnitById(@PathVariable("id") int id) {
        AcademicSubUnit academicSubUnit = this.academicSubUnitService.getAcademicSubUnitById(id);
        if(academicSubUnit != null) return new ResponseEntity<>(academicSubUnit, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicSubUnit> updateAcademicSubUnitById(@PathVariable("id") int id, @RequestBody AcademicSubUnit academicSubUnitBody) {
        AcademicSubUnit academicSubUnit = this.academicSubUnitService.updateAcademicSubUnit(id, academicSubUnitBody);
        if(academicSubUnit != null) return new ResponseEntity<>(academicSubUnit, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("")
    public ResponseEntity<AcademicSubUnit> createAcademicSubUnits(@RequestBody AcademicSubUnit academicSubUnit) {
        AcademicSubUnit academicSubUnitCreated = this.academicSubUnitService.createAcademicSubUnit(academicSubUnit);
        if(academicSubUnitCreated != null) return new ResponseEntity<>(academicSubUnitCreated,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAcademicSubUnit(@PathVariable("id") int id) {
        boolean wasDeleteAcademicSubUnit = this.academicSubUnitService.deleteAcademicSubUnit(id);
        if(wasDeleteAcademicSubUnit) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
