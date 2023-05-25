package com.plangestionestudios.gestion.services.emphasisLine;

import com.plangestionestudios.gestion.entities.AcademicUnit;
import com.plangestionestudios.gestion.entities.EmphasisLine;

import java.util.List;

public interface EmphasisLineService {

    public boolean deleteEmphasisLine(int id);
    public List<EmphasisLine> getAllEmphasisLine();
    public EmphasisLine updateEmphasisLine(int id, EmphasisLine emphasisLine);
    public EmphasisLine getEmphasisLineById(int id);
    public EmphasisLine createEmphasisLine(EmphasisLine emphasisLine);

}
