package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    public void saveDireccion(Direccion direccion);
    public Optional<Direccion> getDireccionById(Long id);
    public List<Direccion> getAllDirecciones();
    public void updateDireccion(Direccion direccion);
}
