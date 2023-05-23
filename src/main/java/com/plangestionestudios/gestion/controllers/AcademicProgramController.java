package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.AcademicProgram;
import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.services.academicProgram.AcademicProgramService;
import com.plangestionestudios.gestion.services.academicUnit.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/academicProgram")
@RestController
public class AcademicProgramController {

    @Autowired
    private AcademicProgramService academicProgramService;

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProgram(@PathVariable("id") int id) {
        boolean wasDeleteAcademicProgram = academicProgramService.deleteAcademicProgram(id);
        if(wasDeleteAcademicProgram) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicProgram> getAcademicProgramById(@PathVariable("id") int id) {
        AcademicProgram academicProgram = academicProgramService.getAcademicProgramById(id);
        if(academicProgram != null) return new ResponseEntity<>(academicProgram, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AcademicProgram>> getAllAcademicProgram() {
        List<AcademicProgram> academicProgramList = academicProgramService.getAllAcademicProgram();
        return new ResponseEntity<>(academicProgramList, HttpStatus.OK);
    }

/*
    @PutMapping("/{id}")
    public ResponseEntity<AcademicUnit> updateAcademicUnitById(@PathVariable("id") int id, @RequestBody AcademicUnit academicUnit) {
        AcademicUnit academicUnitUpdated = this.academicUnitService.updateAcademicUnit(id, academicUnit);
        if(academicUnitUpdated != null) return new ResponseEntity<>(academicUnitUpdated, HttpStatus.OK);
        return new ResponseEntity<>(academicUnitUpdated, HttpStatus.NOT_FOUND);
    }





    @PostMapping("")
    public ResponseEntity<AcademicUnit> createAcademicUnits(@RequestBody AcademicUnit academicUnit) {
        AcademicUnit academicUnitCreated = academicUnitService.createAcademicUnit(academicUnit);
        if(academicUnitCreated != null) {
            return new ResponseEntity<>(academicUnitCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(academicUnitCreated, HttpStatus.BAD_REQUEST);
    }
*/
}
