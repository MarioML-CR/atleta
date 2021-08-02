package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaService {
    public void saveAtleta(Atleta atleta);
    public Optional<Atleta> getAtletaById(Long id);
    public List<Atleta> getAllAtletas();
//    public List<Atleta> findAtletaByName(String nombre);
}
