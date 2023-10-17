package com.ecole.gestionclasses.Repositories;

import com.ecole.gestionclasses.Entities.Etage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtageRepository  extends JpaRepository<Etage, Integer> {
}
