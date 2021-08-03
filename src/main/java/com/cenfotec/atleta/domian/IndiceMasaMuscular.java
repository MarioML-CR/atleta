package com.cenfotec.atleta.domian;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IndiceMasaMuscular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idIMC;
    private float estatura;
    private float peso;
    private float iMC;
    private Date fechaCalculo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public long getIdIMC() {
        return idIMC;
    }

    public void setIdIMC(long idIMC) {
        this.idIMC = idIMC;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getIMC() {
        return iMC;
    }

    public void setIMC(float IMC) {
        this.iMC = IMC;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
