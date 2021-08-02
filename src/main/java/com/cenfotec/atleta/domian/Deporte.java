package com.cenfotec.atleta.domian;

import javax.persistence.*;

@Entity
public class Deporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDeporte;
    private String nombreDeporte;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public Deporte() {
    }

    public Deporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public long getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(long idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "idDeporte=" + idDeporte +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}
