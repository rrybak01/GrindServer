package com.grindServer.grindServer.usuario;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table ( name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String email;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "calorias")
    private String calorias;

    @Column(name = "peso")
    private String peso;

    @Column(name = "benchpress")
    private String benchpress;

    @Column(name = "squat")
    private String squat;

    @Column(name = "deadlift")
    private String deadlift;

    public Usuario(){
    }

    public Usuario(long id, String email, String nombre, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
    }

    public Usuario( String email, String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
    }

    public String toString(){
        return "Usuario{" + 
                "id=" + id +
                ", nombre=" + nombre +
                ", email=" + email +
                ", calorias=" + calorias +
                "}";
    }

    /* public Long getId() {
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    } */

}
