package com.ecole.gestionclasses.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      int id;
        String nom;

        int capacite;



    @ManyToOne
    Section section;
    @ManyToOne
    private Etage etage;



}
