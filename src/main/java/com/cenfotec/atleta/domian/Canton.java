package com.cenfotec.atleta.domian;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCanton;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cantones")
    private Set<Distrito> distritos;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Provincia provincias;

    public Canton() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    public Set<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(Set<Distrito> distritos) {
        this.distritos = distritos;
    }

    public Provincia getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincia provincias) {
        this.provincias = provincias;
    }
}
