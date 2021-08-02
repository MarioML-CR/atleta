package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Distrito;

import java.util.List;
import java.util.Optional;

public interface DistritoService {
    public void saveDistrito(Distrito distrito);
    public Optional<Distrito> getDistritoById(Long id);
    public List<Distrito> getAllDistritos();
}
