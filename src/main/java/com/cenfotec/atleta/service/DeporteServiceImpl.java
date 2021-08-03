package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Deporte;
import com.cenfotec.atleta.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements DeporteService{

    @Autowired
    DeporteRepository deporteRepository;


    @Override
    public void saveDeporte(Deporte deporte) {
        deporteRepository.save(deporte);
    }

    @Override
    public Optional<Deporte> getDeporteById(Long id) {
        return deporteRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Deporte> getAllDeportes() {
        return deporteRepository.findAll();
    }
}
