package com.ecole.gestionclasses.Controllers;

import com.ecole.gestionclasses.Entities.Classe;
import com.ecole.gestionclasses.Entities.Etage;
import com.ecole.gestionclasses.Services.ClasseService;
import com.ecole.gestionclasses.Services.EtageService;
import com.ecole.gestionclasses.Services.SectionService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    @PostMapping(value="/addclasse/{idetage}/{idsection}")

    public ResponseEntity<Classe> createClasse(@RequestBody Classe classe, KeycloakAuthenticationToken auth,
                                               @PathVariable("idetage") int id,
                                               @PathVariable("idsection") int idsection
                                               ) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");

        if (hasUserRole) {
            return new ResponseEntity<>(classeService.createClasse(classe,id,idsection),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

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

    @DeleteMapping( value="/deleteClasse/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteClasse(@PathVariable("id") int id, KeycloakAuthenticationToken auth) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasAdminRole = context.getToken().getRealmAccess().isUserInRole("admin");


        if (hasAdminRole) {
            classeService.deleteClasse(id);
            return new ResponseEntity<>("Class deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Access denied", HttpStatus.FORBIDDEN);
        }
    }


 }
