package com.ecole.gestionclasses.Services;

import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Repositories.EtageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtageService {

    @Autowired
    private EtageRepository etageRepository;

    public Etage createEtage(Etage etage) {
        return etageRepository.save(etage);
    }

    public Etage getEtageById(int id) {
        return etageRepository.findById(id).orElse(null);
    }
    public List<Etage> getAllEtages() {
        return etageRepository.findAll();
    }
    public Etage updateEtage(int id, Etage updatedEtage) {
        Etage existingEtage = getEtageById(id);

        if (existingEtage != null) {
            existingEtage.setLibelle(updatedEtage.getLibelle());
            return etageRepository.save(existingEtage);
        }

        return null;
    }

    public void deleteEtage(int id) {
        etageRepository.deleteById(id);
    }
}
