package com.example.grafos.controller;

import com.exemplo.grafos.service.GrafoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grafos") 
public class GrafoController {

    private final GrafoService grafoService;

    public GrafoController(GrafoService grafoService) {
        this.grafoService = grafoService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/criarGrafo")
    public String criarGrafo(@RequestParam boolean direcional, 
                             @RequestParam boolean ponderado,
                             @RequestParam int numeroNos, 
                             Model model) {
        System.out.println("Direcional: " + direcional);
        System.out.println("Ponderado: " + ponderado);
        System.out.println("Número de Nós: " + numeroNos);
        grafoService.criarGrafo(direcional, ponderado, numeroNos);
        model.addAttribute("grafo", grafoService.getGrafo());
        return "grafo";
    }

    @PostMapping("/adicionarAresta")
    public String adicionarAresta(@RequestParam String origem, @RequestParam String destino,
                                  @RequestParam(required = false) Integer peso, Model model) {
        grafoService.adicionarAresta(origem, destino, peso);
        model.addAttribute("grafo", grafoService.getGrafo());
        return "grafo";
    }

    @PostMapping("/executarOrdenacao")
    public String executarOrdenacao(Model model) {
        model.addAttribute("resultado", grafoService.ordenacaoTopologica());
        return "resultado"; 
    }
}
