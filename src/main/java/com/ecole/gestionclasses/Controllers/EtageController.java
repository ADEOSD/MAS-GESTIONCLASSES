package com.ecole.gestionclasses.Controllers;

import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Services.ClasseService;
import com.ecole.gestionclasses.Services.EtageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etages")

public class EtageController {

    private final EtageService etageService;


    @Autowired
    public EtageController(EtageService etageService) {
        this.etageService = etageService;
    }
    @PostMapping("/addEtage")
    public ResponseEntity<Etage> createEtage(@RequestBody Etage etage) {
        Etage createdEtage = etageService.createEtage(etage);
        return new ResponseEntity<>(createdEtage, HttpStatus.CREATED);
    }

    @GetMapping("getEtageById/{id}")
    public ResponseEntity<Etage> getEtageById(@PathVariable("id") int id) {
        Etage etage = etageService.getEtageById(id);
        if (etage != null) {
            return new ResponseEntity<>(etage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateEtage/{id}")
    public ResponseEntity<Etage> updateEtage(@PathVariable("id") int id, @RequestBody Etage updatedEtage) {
        Etage updated = etageService.updateEtage(id, updatedEtage);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("getAllEtages")
    public List<Etage> getAllEtages() {
        return  etageService.getAllEtages();
    }
    @DeleteMapping("/deleteEtage/{id}")
    public ResponseEntity<Void> deleteEtage(@PathVariable("id") int id) {
        etageService.deleteEtage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
