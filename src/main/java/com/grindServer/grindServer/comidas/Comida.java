package com.grindServer.grindServer.comidas;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.grindServer.grindServer.alimento.Alimento;

@Entity
@Table(name = "comidas")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JoinTable(
        name = "alimentoscomidas",
        joinColumns = @JoinColumn(name = "idcomida", nullable = false),
        inverseJoinColumns = @JoinColumn(name="idalimento", nullable = false)
    )
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Alimento> alimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "idusuario")
    private Long idUsuario;

    public Comida() {
    }

    public Comida(Long id, String nombre, Date fecha, Long idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public Comida(String nombre, Date fecha, Long idUsuario) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public Comida(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Comida(String nombre, Long idUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public Set<Alimento> getAlimento(){
        return alimento;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha(){
        return fecha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
