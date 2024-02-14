package edu.proyecto.monopoly.proyecto_monopoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.proyecto.monopoly.proyecto_monopoly.model.db.PartidaDb;

@Repository
public interface PartidaRepository extends JpaRepository<PartidaDb, Long>{
    
} 