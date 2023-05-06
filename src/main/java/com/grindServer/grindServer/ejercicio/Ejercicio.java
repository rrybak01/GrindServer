package com.grindServer.grindServer.ejercicio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grindServer.grindServer.entrenamiento.Entrenamiento;

import lombok.Data;

@Entity
@Table(name = "Ejercicios")
@Data
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "img")
    private String img;

    @ManyToMany(mappedBy = "ejercicio", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Entrenamiento> entrenamiento = new HashSet<>();

    public Set<Entrenamiento> getEntrenamiento(){
        return entrenamiento;
    }

    public Ejercicio() {
    }

    public Ejercicio(long id, String nombre, String img) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
    }

    public Ejercicio(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Ejercicios{" +
                "id=" + id +
                ", nombre=" + nombre +
                "}";
    }

    /* public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImg() {
        return img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImg(String img) {
        this.img = img;
    } */

}
