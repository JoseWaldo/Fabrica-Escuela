package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.CurriculumVersion;
import com.plangestionestudios.gestion.services.curriculumVersion.CurriculumVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/curriculumVersion")
@RestController
public class CurriculumVersionController {

    @Autowired
    private CurriculumVersionService curriculumVersionService;

    @PostMapping("")
    public ResponseEntity<CurriculumVersion> createCurriculumVersion(@RequestBody CurriculumVersion curriculumVersion){
        CurriculumVersion curriculumVersionCreated = this.curriculumVersionService.createCurriculumVersion(curriculumVersion);
        if(curriculumVersionCreated != null) return new ResponseEntity<>(curriculumVersionCreated, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CurriculumVersion>> getAllCurriculumVersion() {
        List<CurriculumVersion> curriculumVersionList = this.curriculumVersionService.getAllCurriculumVersion();
        return new ResponseEntity<>(curriculumVersionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculumVersion> getByIdCurriculumVersion(@PathVariable("id") int id) {
        CurriculumVersion curriculumVersion = this.curriculumVersionService.getByIdCurriculumVersion(id);
        if(curriculumVersion != null) return new ResponseEntity<>(curriculumVersion, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteByIdCurriculumVersion(@PathVariable("id") int id) {
        boolean wasDeleteCurriculumVersion = this.curriculumVersionService.deleteCurriculumVersion(id);
        if(wasDeleteCurriculumVersion) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
