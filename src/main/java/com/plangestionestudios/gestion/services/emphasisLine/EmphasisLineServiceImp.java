package com.plangestionestudios.gestion.services.emphasisLine;

import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.entities.EmphasisLine;
import com.plangestionestudios.gestion.repositories.AcademicUnitRepository;
import com.plangestionestudios.gestion.repositories.EmphasisLineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class EmphasisLineServiceImp implements EmphasisLineService {


    private EmphasisLineRepository emphasisLineRepository;
    @Override
    public boolean deleteEmphasisLine(int id) {
        EmphasisLine emphasisLineFound = this.getEmphasisLineById(id);
        if(emphasisLineFound != null){
            emphasisLineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EmphasisLine> getAllEmphasisLine() {
        List<EmphasisLine> emphasisLineList = emphasisLineRepository.findAll();
        return emphasisLineList;
    }

    @Override
    public EmphasisLine updateEmphasisLine(int id, EmphasisLine emphasisLine) {
        return null;
    }

    @Override
    public EmphasisLine getEmphasisLineById(int id) {
        Optional<EmphasisLine> emphasisLine = emphasisLineRepository.findById(id);
        if(emphasisLine.isPresent()) return emphasisLine.get();
        return null;

    }

    @Override
    public EmphasisLine createEmphasisLine(EmphasisLine emphasisLine) {
        return null;
    }
}
