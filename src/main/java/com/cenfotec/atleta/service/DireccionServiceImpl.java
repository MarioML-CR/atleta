package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Direccion;
import com.cenfotec.atleta.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    DireccionRepository direccionRepository;


    @Override
    public void saveDireccion(Direccion direccion) { direccionRepository.save(direccion); }

    @Override
    public Optional<Direccion> getCorreoById(Long id) {
        return direccionRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Direccion> getAllDirecciones() { return direccionRepository.findAll(); }
}
