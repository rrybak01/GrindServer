package com.grindServer.grindServer.alimentosComidas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentosComidasRepository extends JpaRepository<AlimentosComidas, Long>{
    
}