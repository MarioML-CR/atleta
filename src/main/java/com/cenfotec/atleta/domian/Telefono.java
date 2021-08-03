package com.cenfotec.atleta.domian;


import javax.persistence.*;

@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTelefono;
    private String numero;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

    public long getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(long idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numTelefono) {
        this.numero = numTelefono;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
