package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Provincia;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {
    public void saveProvincia(Provincia provincia);
    public Optional<Provincia> getProvinciaById(Long id);
    public List<Provincia> getAllProvincias();
}
