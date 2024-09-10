package com.example.grafos.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.example.grafos.model.Grafo;
import com.example.grafos.model.No;

public class OrdenacaoTopologica {

    private Set<No> visitado;
    private Stack<No> pilha;

    public OrdenacaoTopologica() {
        this.visitado = new HashSet<>();
        this.pilha = new Stack<>();
    }

    public Stack<No> executar(Grafo grafo) {
        for (No no : grafo.getNos().values()) {
            if (!visitado.contains(no)) {
                ordenacaoProfundidade(no);
            }
        }
        return pilha; 
    }
    private void ordenacaoProfundidade(No no) {
        visitado.add(no);
        for (var aresta : no.getArestas()) {
            No destino = aresta.getDestino();
            if (!visitado.contains(destino)) {
                ordenacaoProfundidade(destino);
            }
        }
        pilha.push(no); 
    }
}
