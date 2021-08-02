package com.cenfotec.atleta.repository;

import com.cenfotec.atleta.domian.Correo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorreoRepository extends JpaRepository<Correo, Long> {
}
