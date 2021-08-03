package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    public void saveDireccion(Direccion direccion);
    public Optional<Direccion> getCorreoById(Long id);
    public List<Direccion> getAllDirecciones();
}
