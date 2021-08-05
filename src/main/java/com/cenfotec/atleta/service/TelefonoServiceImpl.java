package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Telefono;
import com.cenfotec.atleta.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefonoServiceImpl implements TelefonoService{
    @Autowired
    TelefonoRepository telefonoRepository;

    @Override
    public void saveTelefono(Telefono telefono) {
        telefonoRepository.save(telefono);
    }

    @Override
    public Optional<Telefono> getTelefonoById(Long id) {
        return telefonoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Telefono> getAllTelefonos() {
        return telefonoRepository.findAll();
    }

    @Override
    public void updateTelefono(Telefono telefono) {
        Optional<Telefono> record = telefonoRepository.findById(telefono.getIdTelefono());
        if (record.isPresent()) {
            Telefono data = record.get();
            data.setIdTelefono(telefono.getIdTelefono());
            data.setNumero(telefono.getNumero());
            telefonoRepository.save(data);
        }
    }
}
