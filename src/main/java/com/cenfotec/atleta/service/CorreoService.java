package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Correo;

import java.util.List;
import java.util.Optional;

public interface CorreoService {
    public void saveCorreo(Correo correo);
    public Optional<Correo> getCorreoById(Long id);
    public List<Correo> getAllCorreos();
    public void updateCorreo(Correo correo);
}
