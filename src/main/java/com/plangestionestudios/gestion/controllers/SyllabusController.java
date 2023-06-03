package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.Syllabus;
import com.plangestionestudios.gestion.services.syllabus.SyllabusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/syllabus")
@RestController

public class SyllabusController {

    @Autowired
     private SyllabusServices syllabusServices;



}
