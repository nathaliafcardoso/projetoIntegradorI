package com.univesp.projetoIntegradorI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AgendamentoSalao {
    @Id
    private Long id;
    private Long moradorId;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String motivo; // Pode ser para festa, reunião, etc.

}