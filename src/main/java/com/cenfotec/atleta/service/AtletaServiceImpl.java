package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Atleta;
import com.cenfotec.atleta.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService{
    @Autowired
    AtletaRepository atletaRepository;

    @Override
    public void saveAtleta(Atleta atleta) {
        atletaRepository.save(atleta);
    }

    @Override
    public Optional<Atleta> getAtletaById(Long id) {
        return atletaRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Atleta> getAllAtletas() {
        return atletaRepository.findAll();
    }

//    @Override
//    public List<Atleta> findAtletaByName(String nombre) {
//        return atletaRepository.findAtletaByNombreContaining(nombre);
//    }
}
