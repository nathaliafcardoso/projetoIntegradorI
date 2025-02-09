package com.univesp.projetoIntegradorI.controller;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import com.univesp.projetoIntegradorI.service.MoradorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorService moradorService;

    public MoradorController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @GetMapping
    public List<Morador> findAll() {
        return moradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarPorId(@PathVariable Long id) {
        Morador morador = moradorService.findById(id);
        if (morador != null) {
            return ResponseEntity.ok(morador);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Morador morador) {
        try {
            moradorService.salvarMorador(morador);
            return ResponseEntity.status(HttpStatus.CREATED).body("Morador saved successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Morador moradorAtualizado) {
        try {
            moradorService.atualizarMorador(id, moradorAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body("Morador updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        moradorService.deleteById(id);
    }

    @GetMapping("/moradorForm")
    public String showMoradorForm() {
        return "moradorForm";
    }
}