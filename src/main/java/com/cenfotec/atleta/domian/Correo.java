package com.cenfotec.atleta.domian;

import javax.persistence.*;

@Entity
public class Correo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCorreo;
    private String mail;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Atleta atleta;

//    public Correo() {
//    }

    public long getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(long idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String correo) {
        this.mail = correo;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
