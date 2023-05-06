package com.grindServer.grindServer.comidas;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long>{

    @Query(value = "select c from Comida c"
        + " where (:idUsuario is null or c.idUsuario = :idUsuario) "
        + " and (:date is null or c.fecha = :date)")
    public List<Comida> findByIdUsuario(@Param("idUsuario") Long idUsuario, @Param("date") Date date);
    
}
