package com.ecole.gestionclasses.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_section ;

    String nom_section ;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Classe> classes;
}
