package com.cenfotec.atleta.repository;

import com.cenfotec.atleta.domian.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeporteRepository extends JpaRepository<Deporte, Long> {
}
