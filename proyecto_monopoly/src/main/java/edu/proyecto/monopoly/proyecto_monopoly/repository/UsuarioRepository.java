package edu.proyecto.monopoly.proyecto_monopoly.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecto.monopoly.proyecto_monopoly.model.db.UsuarioDb;


public interface UsuarioRepository extends JpaRepository<UsuarioDb, Long>{
    Optional<UsuarioDb> findByNickname(String nickname);
    Optional<UsuarioDb> findById(Integer id);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    Page<UsuarioDb> findAll(Pageable pageable);
    void deleteByNickname(String nickname);

}
