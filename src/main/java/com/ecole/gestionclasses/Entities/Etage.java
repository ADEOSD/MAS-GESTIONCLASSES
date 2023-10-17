package com.ecole.gestionclasses.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etage implements Serializable {

    @Id
            @GeneratedValue(strategy=GenerationType.IDENTITY)
      int id ;
      String libelle ;
    @OneToMany(mappedBy = "etage", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Classe> classes;




}
