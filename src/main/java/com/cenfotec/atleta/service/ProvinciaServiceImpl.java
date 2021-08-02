package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Provincia;
import com.cenfotec.atleta.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{
    @Autowired
    ProvinciaRepository provinciaRepository;


    @Override
    public void saveProvincia(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }
}
