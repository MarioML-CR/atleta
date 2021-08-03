package com.cenfotec.atleta.domian;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAtleta;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Correo> correos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Telefono> telefonos;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta_deporte")
//    private Set<Deporte> deportes;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta_provincia")
//    private Set<Provincia> provincias;

//    public Atleta() {
//    }

    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(Set<Correo> correos) {
        this.correos = correos;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

//    public Set<Deporte> getDeportes() {
//        return deportes;
//    }
//
//    public void setDeportes(Set<Deporte> deportes) {
//        this.deportes = deportes;
//    }
//
//    public Set<Provincia> getProvincias() {
//        return provincias;
//    }
//
//    public void setProvincias(Set<Provincia> provincias) {
//        this.provincias = provincias;
//    }
}
