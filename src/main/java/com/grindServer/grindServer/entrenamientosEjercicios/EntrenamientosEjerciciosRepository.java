package com.grindServer.grindServer.entrenamientosEjercicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntrenamientosEjerciciosRepository extends JpaRepository<EntrenamientosEjercicios, Long>{

    @Modifying
    @Transactional
    @Query(value = "delete EntrenamientosEjercicios e "
        + " where (:id is null or e.identrenamiento = :id)")
    public void deleteByEntrenamiento(@Param("id") Long idEntrenamiento);
    
}