package com.univesp.projetoIntegradorI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Morador {

        @Id
        private Long id;
        private String nome;
        private String numeroCasa;
        private String telefone;
        private String email;
        private String horariosPresenca;
        private String observacoes;

        @OneToMany
        private List<Morador> moradoresDaCasa;

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
                this.telefone = removeSpecialCharacters(telefone);
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

        public List<Morador> getMoradoresDaCasa() {
                return moradoresDaCasa;
        }

        public void setMoradoresDaCasa(List<Morador> moradoresDaCasa) {
                this.moradoresDaCasa = moradoresDaCasa;
        }

        private String removeSpecialCharacters(String input) {
                return input != null ? input.replaceAll("[^a-zA-Z0-9]", "") : null;
        }
}