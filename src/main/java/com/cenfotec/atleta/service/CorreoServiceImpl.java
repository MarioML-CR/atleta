package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Correo;
import com.cenfotec.atleta.repository.CorreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorreoServiceImpl implements CorreoService{

    @Autowired
    CorreoRepository correoRepository;


    @Override
    public void saveCorreo(Correo correo) { correoRepository.save(correo); }

    @Override
    public Optional<Correo> getCorreoById(Long id) {
        return correoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Correo> getAllCorreos() {
        return correoRepository.findAll();
    }

    @Override
    public void updateCorreo(Correo correo) {
        Optional<Correo> record = correoRepository.findById(correo.getIdCorreo());
        if (record.isPresent()) {
            Correo data = record.get();
            data.setIdCorreo(correo.getIdCorreo());
            data.setMail(correo.getMail());
            correoRepository.save(data);
        }
    }
}
