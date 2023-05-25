package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.CurriculumVersion;
import com.plangestionestudios.gestion.services.curriculumVersion.CurriculumVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
