package com.ecole.gestionclasses.Services;

import com.ecole.gestionclasses.Entities.Classe;
import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Entities.Section;
import com.ecole.gestionclasses.Repositories.ClasseRepository;
import com.ecole.gestionclasses.Repositories.EtageRepository;
import com.ecole.gestionclasses.Repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {


    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private EtageRepository etageRepository;
    @Autowired
    private SectionRepository sectionRepository;
    public Classe createClasse(Classe classe,int etageId , int idsection) {
        Etage etage = etageRepository.findById(etageId).orElse(null);
        Section section = sectionRepository.findById(idsection).orElse(null);

        if (etage != null && section!=null ) {

            classe.setEtage(etage);
            classe.setSection(section);
            return classeRepository.save(classe);
        }

        return null; // Handle the case where the Etage does not exist
    }
    public Classe getClasseById(int id) {
        return classeRepository.findById(id).orElse(null);
    }

    public List<Classe> getAllClasses (){
        return  classeRepository.findAll();
    }
    public Classe updateClasse(int id, Classe updatedClasse) {
        Classe existingClasse = getClasseById(id);

        if (existingClasse != null) {
            existingClasse.setNom(updatedClasse.getNom());
            existingClasse.setCapacite(updatedClasse.getCapacite());
            existingClasse.setEtage(updatedClasse.getEtage()); // Assuming you have a method to get the Etage
            return classeRepository.save(existingClasse);
        }

        return null;
    }

    public void deleteClasse(int id) {
        classeRepository.deleteById(id);
    }

}
