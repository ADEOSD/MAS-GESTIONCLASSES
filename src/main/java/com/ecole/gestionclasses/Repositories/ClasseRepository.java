package com.ecole.gestionclasses.Repositories;

import com.ecole.gestionclasses.Entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository  extends JpaRepository<Classe, Integer> {

}
