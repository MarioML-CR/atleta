package com.cenfotec.atleta.domian;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Provincia {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreProvincia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia")
    private Set<Canton> cantones;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public Provincia() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public Set<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(Set<Canton> cantones) {
        this.cantones = cantones;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
