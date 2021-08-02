package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Canton;
import com.cenfotec.atleta.repository.CantonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantonServiceImpl implements CantonService{
    @Autowired
    CantonRepository cantonRepository;

    @Override
    public void saveCanton(Canton canton) {
        cantonRepository.save(canton);
    }

    @Override
    public Optional<Canton> getCantonById(Long id) {
        return cantonRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<Canton> getAllCantones() {
        return cantonRepository.findAll();
    }
}
