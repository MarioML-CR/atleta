package com.cenfotec.atleta.domian;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IndiceMasaMuscular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float estatura;
    private float peso;
    private float IMC;
    private Date fechaCalculo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public IndiceMasaMuscular() {
    }

    public IndiceMasaMuscular(float estatura, float peso, float IMC, Date fechaCalculo) {
        this.estatura = estatura;
        this.peso = peso;
        this.IMC = IMC;
        this.fechaCalculo = fechaCalculo;
    }

    public IndiceMasaMuscular(float estatura, float peso, float IMC, Date fechaCalculo, Atleta atleta) {
        this.estatura = estatura;
        this.peso = peso;
        this.IMC = IMC;
        this.fechaCalculo = fechaCalculo;
        this.atleta = atleta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
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

    @Override
    public String toString() {
        return "IndiceMasaMuscular{" +
                "id=" + id +
                ", estatura=" + estatura +
                ", peso=" + peso +
                ", IMC=" + IMC +
                ", fechaCalculo=" + fechaCalculo +
                ", atleta=" + atleta +
                '}';
    }
}
