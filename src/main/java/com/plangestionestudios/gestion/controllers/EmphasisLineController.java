package com.plangestionestudios.gestion.controllers;

import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.entities.EmphasisLine;
import com.plangestionestudios.gestion.services.emphasisLine.EmphasisLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("api/emphasisLine")
@RestController

public class EmphasisLineController {

    private EmphasisLineService emphasisLineService;

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBloque(@PathVariable("id") int id) {
        boolean wasDeleteEmphasisLine = emphasisLineService.deleteEmphasisLine(id);
        if(wasDeleteEmphasisLine) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmphasisLine>> getAllEmphasisLine() {
        List<EmphasisLine> emphasisLineList = emphasisLineService.getAllEmphasisLine();
        return new ResponseEntity<>(emphasisLineList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmphasisLine> getEmphasisLineById(@PathVariable("id") int id) {
        EmphasisLine emphasisLine = emphasisLineService.getEmphasisLineById(id);
        if (emphasisLine != null) return new ResponseEntity<>(emphasisLine, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

}
