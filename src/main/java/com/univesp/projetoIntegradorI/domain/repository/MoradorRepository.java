package com.univesp.projetoIntegradorI.domain.repository;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

}

