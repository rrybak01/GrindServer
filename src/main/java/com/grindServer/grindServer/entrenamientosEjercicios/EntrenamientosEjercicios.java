package com.grindServer.grindServer.entrenamientosEjercicios;

import javax.persistence.*;

@Entity
@Table ( name = "entrenamientosejercicios")
public class EntrenamientosEjercicios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identrenamiento")
    private Long identrenamiento;

    @Column(name = "idejercicio")
    private Long idejercicio;

    public EntrenamientosEjercicios(){
    }

    public EntrenamientosEjercicios(Long id, Long identrenamiento, Long idejercicio){
        this.id = id;
        this.identrenamiento = identrenamiento;
        this.idejercicio = idejercicio;
    }

    public EntrenamientosEjercicios(Long identrenamiento, Long idejercicio){
        this.identrenamiento = identrenamiento;
        this.idejercicio = idejercicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentrenamiento() {
        return identrenamiento;
    }

    public void setIdentrenamiento(Long identrenamiento) {
        this.identrenamiento = identrenamiento;
    }

    public Long getIdejercicio() {
        return idejercicio;
    }

    public void setIdejercicio(Long idejercicio) {
        this.idejercicio = idejercicio;
    }
    

}
