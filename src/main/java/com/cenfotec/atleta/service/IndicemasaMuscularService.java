package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.IndiceMasaMuscular;

import java.util.List;
import java.util.Optional;

public interface IndiceMasaMuscularService {
    public void saveIndiceMasaMuscular(IndiceMasaMuscular indiceMasaMuscular);
    public Optional<IndiceMasaMuscular> getIndiceMasaMuscularById(Long id);
    public List<IndiceMasaMuscular> getAllIndicesMasaMuscular();
}
