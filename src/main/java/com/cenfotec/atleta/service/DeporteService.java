package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Deporte;

import java.util.List;
import java.util.Optional;

public interface DeporteService {
    public void saveDeporte(Deporte deporte);
    public Optional<Deporte> getDeporteById(Long id);
    public List<Deporte> getAllDeportes();
}
