package com.cenfotec.atleta.repository;

import com.cenfotec.atleta.domian.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
//    public List<Atleta> findAtletaByNombreContaining(String word);
}
