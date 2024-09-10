package com.example.grafos.model;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private Map<String, No> nos;
    private boolean direcional;
    private boolean ponderado;

    public Grafo(boolean direcional, boolean ponderado) {
        this.nos = new HashMap<>();
        this.direcional = direcional;
        this.ponderado = ponderado;
    }

    public void addNo(String nome) {
        nos.putIfAbsent(nome, new No(nome));
    }

    public No getNo(String nome) {
        return nos.get(nome);
    }

    public void addAresta(String origem, String destino, int peso) {
        No noOrigem = getNo(origem);
        No noDestino = getNo(destino);
        noOrigem.addAresta(new Arestas(noDestino, ponderado ? peso : 1, direcional));
        if (!direcional) {
            noDestino.addAresta(new Arestas(noOrigem, ponderado ? peso : 1, direcional));
        }
    }

    public Map<String, No> getNos() {
        return nos;
    }
}