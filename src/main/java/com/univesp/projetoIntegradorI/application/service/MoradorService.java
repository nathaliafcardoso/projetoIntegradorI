package com.univesp.projetoIntegradorI.application.service;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import com.univesp.projetoIntegradorI.domain.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }

    public Morador salvarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public void removerMorador(Long id) {
        moradorRepository.deleteById(id);
    }
}