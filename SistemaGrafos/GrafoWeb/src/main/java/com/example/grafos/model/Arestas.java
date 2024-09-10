package com.example.grafos.model;

public class Arestas {
    private No destino;
    private int peso;
    private boolean direcional;

    public Arestas(No destino, int peso, boolean direcional) {
        this.destino = destino;
        this.peso = peso;
        this.direcional = direcional;
    }

    public No getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public boolean isDirecional() {
        return direcional;
    }
}