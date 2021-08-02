package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.IndiceMasaMuscular;
import com.cenfotec.atleta.repository.IndiceMasaMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndicemasaMuscularServiceImpl implements IndiceMasaMuscularService {
    @Autowired
    IndiceMasaMuscularRepository indiceMasaMuscularRepository;


    @Override
    public void saveIndiceMasaMuscular(IndiceMasaMuscular indiceMasaMuscular) {
        indiceMasaMuscularRepository.save(indiceMasaMuscular);
    }

    @Override
    public Optional<IndiceMasaMuscular> getIndiceMasaMuscularById(Long id) {
        return indiceMasaMuscularRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public List<IndiceMasaMuscular> getAllIndicesMasaMuscular() {
        return indiceMasaMuscularRepository.findAll();
    }
}
