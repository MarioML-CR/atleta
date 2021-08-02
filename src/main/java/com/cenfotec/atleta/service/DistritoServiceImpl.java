package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Distrito;
import com.cenfotec.atleta.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService{
    @Autowired
    DistritoRepository distritoRepository;


    @Override
    public void saveDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    @Override
    public Optional<Distrito> getDistritoById(Long id) {
        return distritoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Distrito> getAllDistritos() {
        return distritoRepository.findAll();
    }
}
