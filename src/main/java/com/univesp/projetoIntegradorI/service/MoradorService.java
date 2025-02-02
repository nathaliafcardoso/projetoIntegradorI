package com.univesp.projetoIntegradorI.service;

import com.univesp.projetoIntegradorI.domain.model.AgendamentoSalao;
import com.univesp.projetoIntegradorI.domain.model.Morador;
import com.univesp.projetoIntegradorI.domain.repository.AgendamentoSalaoRepository;
import com.univesp.projetoIntegradorI.domain.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private AgendamentoSalaoRepository agendamentoSalaoRepository;

    public Morador salvarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public void atualizarHorariosPresenca(Long moradorId, String horarios) {
        Morador morador = moradorRepository.findById(moradorId).orElseThrow(() -> new RuntimeException("Morador não encontrado"));
        morador.setHorariosPresenca(horarios);
        moradorRepository.save(morador);
    }

    public void atualizarObservacoes(Long moradorId, String observacoes) {
        Morador morador = moradorRepository.findById(moradorId).orElseThrow(() -> new RuntimeException("Morador não encontrado"));
        morador.setObservacoes(observacoes);
        moradorRepository.save(morador);
    }

    public AgendamentoSalao agendarSalao(Long moradorId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String motivo) {
        AgendamentoSalao agendamento = new AgendamentoSalao();
        agendamento.setMoradorId(moradorId);
        agendamento.setDataHoraInicio(dataHoraInicio);
        agendamento.setDataHoraFim(dataHoraFim);
        agendamento.setMotivo(motivo);
        return agendamentoSalaoRepository.save(agendamento);
    }

    public List<Morador> findAll() {
        return moradorRepository.findAll();
    }

    public Morador findById(Long id) {
        return moradorRepository.findById(id).orElseThrow(() -> new RuntimeException("Morador não encontrado"));
    }

    public void deleteById(Long id) {
        moradorRepository.deleteById(id);
    }
}