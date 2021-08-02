package com.cenfotec.atleta.domian;

import javax.persistence.*;

@Entity
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreDistrito;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Canton cantones;

    public Distrito() {
    }

    public Distrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public Canton getCantones() {
        return cantones;
    }

    public void setCantones(Canton cantones) {
        this.cantones = cantones;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "id=" + id +
                ", nombreDistrito='" + nombreDistrito + '\'' +
                '}';
    }
}
