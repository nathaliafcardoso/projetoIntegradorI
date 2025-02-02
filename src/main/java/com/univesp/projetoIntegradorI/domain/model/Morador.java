package com.univesp.projetoIntegradorI.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Morador {

        @Id
        private Long id;
        private String nome;
        private String numeroCasa;
        private String telefone;
        private String email;
        private String horariosPresenca; // Armazena os horários de presença em formato JSON ou texto
        private String observacoes; // Observações de quem não pode entrar na casa
}
