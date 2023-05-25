package com.plangestionestudios.gestion.services.curriculumVersion;

import com.plangestionestudios.gestion.entities.CurriculumVersion;
import com.plangestionestudios.gestion.repositories.CurriculumVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumVersionServiceImp implements CurriculumVersionService {

    @Autowired
    private CurriculumVersionRepository curriculumVersionRepository;

    @Override
    public boolean deleteCurriculumVersion(int id) {
        return false;
    }

    @Override
    public List<CurriculumVersion> getAllCurriculumVersion() {
        return this.curriculumVersionRepository.findAll();
    }

    @Override
    public CurriculumVersion getByIdCurriculumVersion(int id) {
        Optional<CurriculumVersion> curriculumVersionFound = this.curriculumVersionRepository.findById(id);
        if(curriculumVersionFound.isPresent()) return curriculumVersionFound.get();
        return null;
    }

    @Override
    public CurriculumVersion updateCurriculumVersion(int id, CurriculumVersion curriculumVersion) {
        return null;
    }

    @Override
    public CurriculumVersion createCurriculumVersion(CurriculumVersion curriculumVersion) {

        int numCurriculumVersion = curriculumVersion.getNumCurriculumVersion();

        curriculumVersion.setTotalCreditsCurriculumVersion(0);

        if(numCurriculumVersion <= 0 || numCurriculumVersion > 20) return null;

        List<CurriculumVersion> curriculumVersionList = this.curriculumVersionRepository.findByNumCurriculumVersion(numCurriculumVersion);
        if(!curriculumVersionList.isEmpty()) return null;

        this.curriculumVersionRepository.save(curriculumVersion);

        return curriculumVersion;
    }
}
