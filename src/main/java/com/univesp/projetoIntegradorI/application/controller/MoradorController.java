package com.univesp.projetoIntegradorI.application.controller;

import com.univesp.projetoIntegradorI.application.service.MoradorService;
import com.univesp.projetoIntegradorI.domain.model.Morador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public String listarMoradores(Model model) {
        model.addAttribute("moradores", moradorService.listarMoradores());
        return "moradores/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("morador", new Morador());
        return "moradores/formulario";
    }

    @PostMapping("/salvar")
    public String salvarMorador(@ModelAttribute Morador morador) {
        moradorService.salvarMorador(morador);
        return "redirect:/moradores";
    }

    @GetMapping("/remover/{id}")
    public String removerMorador(@PathVariable Long id) {
        moradorService.removerMorador(id);
        return "redirect:/moradores";
    }
}