package com.univesp.projetoIntegradorI.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Morador {

        @Id
        private Long id;
        private String nome;
        private String numeroCasa;
        private String telefone;
        private String email;
        private String horariosPresenca; // Armazena os horários de presença em formato JSON ou texto
        private String observacoes; // Observações de quem não pode entrar na casa

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getNumeroCasa() {
                return numeroCasa;
        }

        public void setNumeroCasa(String numeroCasa) {
                this.numeroCasa = numeroCasa;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getHorariosPresenca() {
                return horariosPresenca;
        }

        public void setHorariosPresenca(String horariosPresenca) {
                this.horariosPresenca = horariosPresenca;
        }

        public String getObservacoes() {
                return observacoes;
        }

        public void setObservacoes(String observacoes) {
                this.observacoes = observacoes;
        }
}
