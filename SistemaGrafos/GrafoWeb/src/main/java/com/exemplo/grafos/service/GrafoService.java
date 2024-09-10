package com.exemplo.grafos.service;

import org.springframework.stereotype.Service;

import com.example.grafos.model.Grafo;

@Service
public class GrafoService {

    private Grafo grafo;

    public void criarGrafo(boolean direcional, boolean ponderado, int numeroNos) {
        grafo = new Grafo(direcional, ponderado);
        for (int i = 0; i < numeroNos; i++) {
            grafo.addNo("No" + (i + 1));
        }
    }

    public void adicionarAresta(String origem, String destino, int peso) {
        grafo.addAresta(origem, destino, peso);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public String ordenacaoTopologica() {
        return "Ordenação executada";
    }
}
