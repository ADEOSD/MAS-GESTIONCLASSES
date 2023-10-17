package com.ecole.gestionclasses.Controllers;

import com.ecole.gestionclasses.Entities.Section;
import com.ecole.gestionclasses.Services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
    private final SectionService sectionservice;

    @Autowired
    public SectionController(SectionService sectionservice) {
        this.sectionservice = sectionservice;
    }


    @GetMapping("getAllSections")
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sections = sectionservice.getAllSections();
        return ResponseEntity.ok(sections);
    }

    @PostMapping("/addSection")
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section createdSection = sectionservice.createSection(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }

    @PutMapping("/updateSection/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable int id, @RequestBody Section section) {
        Section updatedSection = sectionservice.updateSection(id, section);
        return ResponseEntity.ok(updatedSection);
    }

    @DeleteMapping("/deleteSection/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable int id) {
        sectionservice.deleteSection(id);
        return ResponseEntity.noContent().build();
    }
}
