package com.ecole.gestionclasses.Controllers;

import com.ecole.gestionclasses.Entities.Classe;
import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Services.ClasseService;
import com.ecole.gestionclasses.Services.EtageService;
import com.ecole.gestionclasses.Services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")

public final class ClassesController  {

    private final ClasseService classeService;
    private final EtageService etageService;
    private final SectionService sectionService;


    @Autowired
    public ClassesController(ClasseService classeService,EtageService etageService,SectionService sectionService) {
        this.classeService = classeService;
        this.etageService=etageService;
        this.sectionService=sectionService;


    }
 @PostMapping("/addclasse/{idetage}/{idsection}")
    public Classe createClasse(@RequestBody Classe classe , @PathVariable ("idetage") int id , @PathVariable("idsection") int idsection ) {
        return classeService.createClasse(classe,id,idsection);
    }

 @GetMapping("/getclassebyId/{id}")
 public Classe getClasseById(@PathVariable("id") int id) {
 return classeService.getClasseById(id);
 }

 @GetMapping("/getAllClasses")
    public List<Classe> getAllClasses (){
        return  classeService.getAllClasses();
    }

    @PutMapping("/updateClasse/{id}")
    public Classe updateClasse(@PathVariable("id") int id,@RequestBody Classe updatedClasse) {
       return classeService.updateClasse(id,updatedClasse);
    }

    @DeleteMapping("/deleteClasse/{id}")
    public void deleteClasse(@PathVariable("id") int id) {
        classeService.deleteClasse(id);
    }

 }
