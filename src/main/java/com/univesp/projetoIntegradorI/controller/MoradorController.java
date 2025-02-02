package com.univesp.projetoIntegradorI.controller;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import com.univesp.projetoIntegradorI.service.MoradorService;
import org.springframework.web.bind.annotation.*;
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
    public Morador findById(@PathVariable Long id) {
        return moradorService.findById(id);
    }

    @PostMapping
    public Morador save(@RequestBody Morador morador) {
        return moradorService.salvarMorador(morador);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        moradorService.deleteById(id);
    }
}