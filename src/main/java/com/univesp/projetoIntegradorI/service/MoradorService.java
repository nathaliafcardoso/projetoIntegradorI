package com.univesp.projetoIntegradorI.service;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MoradorService {
    private List<Morador> moradores = new ArrayList<>();

    public List<Morador> findAll() {
        return moradores;
    }

    public Morador findById(Long id) {
        return moradores.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        moradores.removeIf(m -> m.getId().equals(id));
    }

    public Morador salvarMorador(Morador morador) {
        String idString = morador.getNumeroCasa() + morador.getTelefone();
        Long id = Long.valueOf(idString.replaceAll("[^0-9]", ""));
        if (findById(id) != null) {
            throw new IllegalArgumentException("ID already exists");
        }
        morador.setId(id);
        moradores.add(morador);
        return morador;
    }

    public Morador atualizarMorador(Long id, Morador moradorAtualizado) {
        Morador moradorExistente = findById(id);
        if (moradorExistente == null) {
            throw new IllegalArgumentException("Morador not found");
        }

        if (!Objects.equals(moradorExistente.getNome(), moradorAtualizado.getNome()) || !Objects.equals(moradorExistente.getEmail(), moradorAtualizado.getEmail())) {
            String newIdString = moradorAtualizado.getNumeroCasa() + moradorAtualizado.getTelefone();
            Long newId = Long.valueOf(newIdString.replaceAll("[^0-9]", ""));
            moradorExistente.setId(newId);
        }

        moradorExistente.setNome(moradorAtualizado.getNome());
        moradorExistente.setNumeroCasa(moradorAtualizado.getNumeroCasa());
        moradorExistente.setTelefone(moradorAtualizado.getTelefone());
        moradorExistente.setEmail(moradorAtualizado.getEmail());
        moradorExistente.setHorariosPresenca(moradorAtualizado.getHorariosPresenca());
        moradorExistente.setObservacoes(moradorAtualizado.getObservacoes());

        return moradorExistente;
    }

    public Morador buscarPorId(Long id) {
        return findById(id);
    }
}