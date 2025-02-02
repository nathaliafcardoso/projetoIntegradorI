package com.univesp.projetoIntegradorI.service;

import com.univesp.projetoIntegradorI.domain.model.AgendamentoSalao;
import com.univesp.projetoIntegradorI.domain.repository.AgendamentoSalaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoSalaoRepository agendamentoSalaoRepository;

    public AgendamentoSalao agendarSalao(Long moradorId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String motivo) {
        // Validação: Verifica se o salão já está agendado para esse horário
        boolean salaOcupada = agendamentoSalaoRepository.findAll().stream()
                .anyMatch(agendamento -> dataHoraInicio.isBefore(agendamento.getDataHoraFim()) &&
                        dataHoraFim.isAfter(agendamento.getDataHoraInicio()));

        if (salaOcupada) {
            throw new RuntimeException("O salão de festas já está agendado para esse horário.");
        }

        AgendamentoSalao agendamento = new AgendamentoSalao();
        agendamento.setMoradorId(moradorId);
        agendamento.setDataHoraInicio(dataHoraInicio);
        agendamento.setDataHoraFim(dataHoraFim);
        agendamento.setMotivo(motivo);

        return agendamentoSalaoRepository.save(agendamento);
    }
}