package com.grindServer.grindServer.entrenamiento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long>{

    @Query(value = "select e from Entrenamiento e")
    public List<Entrenamiento> findEntrenamientos();

    @Query(value = "select max(e.id) from Entrenamiento e")
    public Integer findLastId();

    @Query(value = "select e from Entrenamiento e where (:id is null or e.idusuario = :id)")
    public List<Entrenamiento> findByIdUsuario(@Param("id") Long id);

    @Query(value = "select e from Entrenamiento e where (:id is null or e.id = :id)")
    public Optional<Entrenamiento> findById(@Param("id") Long id);
    
}

