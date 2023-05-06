package com.grindServer.grindServer.alimento;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grindServer.grindServer.comidas.Comida;

import lombok.Data;

@Entity
@Table (name = "Alimentos")
@Data
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "calorias")
    private String calorias;

    @Column(name = "hidratos")
    private Integer hidratos;

    @Column(name = "proteinas")
    private Integer proteinas;

    @Column(name = "grasas")
    private Integer grasas;

    @ManyToMany(mappedBy = "alimento", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Comida> comida = new HashSet<>();

    public Alimento(){
    }

    public Alimento(long id, String nombre, String calorias,Integer hidratos, Integer proteinas, Integer grasas){
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
    }

    public Alimento(String nombre, String calorias, Integer hidratos, Integer proteinas, Integer grasas){
        this.nombre = nombre;
        this.hidratos = hidratos;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
    }

    public String toString(){
        return "Alimento{" + 
                "id=" + id +
                ", nombre=" + nombre +
                ", proteinas=" + proteinas +
                ", hidratos=" + hidratos +
                ", grasas=" + grasas 
                +"}";
    }

    public Set<Comida> getComida(){
        return comida;
    }

    /* public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public Integer getHidratos() {
        return hidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setProteinas(Integer proteinas){
        this.proteinas = proteinas;
    }

    public void setHidratos(Integer hidratos){
        this.hidratos = hidratos;
    }

    public void setGrasas(Integer grasas){
        this.grasas = grasas;
    } */

}
