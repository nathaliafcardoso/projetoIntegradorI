package com.univesp.projetoIntegradorI.domain.repository;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

    List<Morador> findByNumeroCasaContaining(String numeroCasa);  // Busca por número da casa (parcial)
    List<Morador> findAllByOrderByNumeroCasaAsc();  // Ordena por número da casa

}

