package com.univesp.projetoIntegradorI.application.controller;

import com.univesp.projetoIntegradorI.application.service.AgendamentoService;
import com.univesp.projetoIntegradorI.application.service.MoradorService;
import com.univesp.projetoIntegradorI.domain.model.AgendamentoSalao;
import com.univesp.projetoIntegradorI.domain.model.Morador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/salvar")
    public Morador salvarMorador(@RequestBody Morador morador) {
        return moradorService.salvarMorador(morador);
    }

    @PutMapping("/atualizar-horarios/{moradorId}")
    public void atualizarHorarios(@PathVariable Long moradorId, @RequestBody String horarios) {
        moradorService.atualizarHorariosPresenca(moradorId, horarios);
    }

    @PutMapping("/atualizar-observacoes/{moradorId}")
    public void atualizarObservacoes(@PathVariable Long moradorId, @RequestBody String observacoes) {
        moradorService.atualizarObservacoes(moradorId, observacoes);
    }

    @PostMapping("/agendar-salao")
    public AgendamentoSalao agendarSalao(@RequestParam Long moradorId,
                                         @RequestParam String dataHoraInicio,
                                         @RequestParam String dataHoraFim,
                                         @RequestParam String motivo) {
        LocalDateTime inicio = LocalDateTime.parse(dataHoraInicio);
        LocalDateTime fim = LocalDateTime.parse(dataHoraFim);
        return agendamentoService.agendarSalao(moradorId, inicio, fim, motivo);
    }
}