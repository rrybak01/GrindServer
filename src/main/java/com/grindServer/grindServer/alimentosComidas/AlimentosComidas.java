package com.grindServer.grindServer.alimentosComidas;

import javax.persistence.*;

@Entity
@Table ( name = "alimentoscomidas")
public class AlimentosComidas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idalimento")
    private Long idalimento;

    @Column(name = "idcomida")
    private Long idcomida;

    public AlimentosComidas(){
    }

    public AlimentosComidas(Long id, Long idalimento, Long idcomida){
        this.id = id;
        this.idalimento = idalimento;
        this.idcomida = idcomida;
    }

    public AlimentosComidas(Long idalimento, Long idcomida){
        this.idalimento = idalimento;
        this.idcomida = idcomida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Long idalimento) {
        this.idalimento = idalimento;
    }

    public Long getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Long idcomida) {
        this.idcomida = idcomida;
    }

}
