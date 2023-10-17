package com.ecole.gestionclasses.Services;

import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Entities.Section;
import com.ecole.gestionclasses.Repositories.EtageRepository;
import com.ecole.gestionclasses.Repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;


    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section getSectionById(int id) {
        return sectionRepository.findById(id).orElse(null);
    }
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
    public Section updateSection(int id, Section updatedSection) {
        Section existingSection = getSectionById(id);

        if (existingSection != null) {
            existingSection.setNom_section(updatedSection.getNom_section());
            return sectionRepository.save(existingSection);
        }
        return null;
    }
    public void deleteSection(int id) {
        sectionRepository.deleteById(id);
    }

}
