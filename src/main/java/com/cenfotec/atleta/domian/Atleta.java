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
    private String sexo;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Correo> correos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Telefono> telefonos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<IndiceMasaMuscular> indicesMasaMuscular;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Deporte> deportes;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atleta")
    private Set<Direccion> direcciones;

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

    public Set<IndiceMasaMuscular> getIndicesMasaMuscular() {
        return indicesMasaMuscular;
    }

    public void setIndicesMasaMuscular(Set<IndiceMasaMuscular> indicesMasaMuscular) {
        this.indicesMasaMuscular = indicesMasaMuscular;
    }

    public Set<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(Set<Deporte> deportes) {
        this.deportes = deportes;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
}
