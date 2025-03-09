package com.univesp.projetoIntegradorI.controller;

import com.univesp.projetoIntegradorI.domain.model.Morador;
import com.univesp.projetoIntegradorI.service.MoradorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@Controller  // Mudança de @RestController para @Controller
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorService moradorService;

    public MoradorController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";  // Página com o menu de opções
    }

    @GetMapping("/listarMoradores")
    public String listarMoradores(Model model) {
        List<Morador> moradores = moradorService.findAll(); // Agora já retorna ordenado
        model.addAttribute("moradores", moradores);
        return "listarMoradores";
    }

    // Método para buscar morador por número da casa
    @GetMapping("/buscarPorNumeroCasa")
    public String buscarPorNumeroCasa(@RequestParam("numeroCasa") String numeroCasa, Model model) {
        List<Morador> moradores = moradorService.buscarPorNumeroCasa(numeroCasa);
        System.out.println("Moradores encontrados: " + moradores.size());
        model.addAttribute("moradores", moradores);
        return "listarMoradores";  // Retorna a página com a lista de moradores
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
            return ResponseEntity.status(HttpStatus.CREATED).body("Morador salvo com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Morador moradorAtualizado) {
        try {
            moradorService.atualizarMorador(id, moradorAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body("Morador atualizado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/deletarMorador/{id}")
    public String deletarMorador(@PathVariable Long id) {
        moradorService.deleteById(id);  // Deleta o morador pelo ID
        return "redirect:/moradores/listarMoradores";  // Redireciona de volta para a lista
    }


    @GetMapping("/moradorForm")
    public String showMoradorForm(Model model) {
        model.addAttribute("morador", new Morador());
        return "moradorForm";  // Nome do template
    }

//    @PostMapping("/moradorForm")
//    public String processarFormulario(@ModelAttribute("morador") Morador morador) {
//        try {
//            moradorService.salvarMorador(morador);  // Salva o morador
//            return "redirect:/moradores/cadastro-sucesso";  // Redireciona para página de sucesso
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";  // Página de erro personalizada, se configurada
//        }
//    }

    // Mapeamento para a página de sucesso após cadastro
    @GetMapping("/cadastro-sucesso")
    public String showSuccessPage() {
        return "cadastro-sucesso";  // Certifique-se de que este template existe na pasta de templates
    }

    @PostMapping("/moradorForm")
    public String processarFormulario(@ModelAttribute("morador") Morador morador, Model model) {
        try {
            moradorService.salvarMorador(morador);
            model.addAttribute("morador", morador);
            return "cadastro-sucesso";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
