package com.grindServer.grindServer.entrenamiento;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.grindServer.grindServer.ejercicio.Ejercicio;

@Entity
@Table(name = "Entrenamientos")
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "idusuario")
    private Long idusuario;

    @JoinTable(
        name = "entrenamientosejercicios",
        joinColumns = @JoinColumn(name = "identrenamiento", nullable = false),
        inverseJoinColumns = @JoinColumn(name="idejercicio", nullable = false)
    )
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ejercicio> ejercicio;

    public Entrenamiento() {
    }

    public Entrenamiento(Long id, String nombre, String duracion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Entrenamiento(Long id, String nombre, Long idusuario) {
        this.id = id;
        this.nombre = nombre;
        this.idusuario = idusuario;
    }

    public Entrenamiento(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Entrenamiento(String nombre, Long idusuario) {
        this.nombre = nombre;
        this.idusuario = idusuario;
    }

    public String toString() {
        return "Entrenamiento{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", druación= " + duracion +
                "}";
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public Long getIdUsuario() {
        return idusuario;
    }

    public Set<Ejercicio> getEjercicio(){
        return ejercicio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setIdUsuario(Long idusuario) {
        this.idusuario = idusuario;
    }

}
