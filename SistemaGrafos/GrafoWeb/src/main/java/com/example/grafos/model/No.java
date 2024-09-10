package com.example.grafos.model;

import java.util.ArrayList;
import java.util.List;

public class No {
    private String nome;
    private List<Arestas> arestas;

    public No(String nome) {
        this.nome = nome;
        this.arestas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Arestas> getArestas() {
        return arestas;
    }

    public void addAresta(Arestas aresta) {
        this.arestas.add(aresta);
    }
}
