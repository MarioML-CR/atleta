package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Telefono;

import java.util.List;
import java.util.Optional;

public interface TelefonoService {
    public void saveTelefono(Telefono telefono);
    public Optional<Telefono> getTelefonoById(Long id);
    public List<Telefono> getAllTelefonos();
}
