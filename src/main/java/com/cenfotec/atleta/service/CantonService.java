package com.cenfotec.atleta.service;

import com.cenfotec.atleta.domian.Canton;

import java.util.List;
import java.util.Optional;

public interface CantonService {
    public void saveCanton(Canton canton);
    public Optional<Canton> getCantonById(Long id);
    public List<Canton> getAllCantones();
}
