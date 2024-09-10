package com.example.grafos.algorithm;

import java.util.*;

import com.example.grafos.model.Grafo;
import com.example.grafos.model.No;

public class Dijkstra {

    public Map<No, Integer> executar(Grafo grafo, String origem) {
        Map<No, Integer> distancias = new HashMap<>();
        PriorityQueue<NoDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(NoDistancia::getDistancia));
        Set<No> visitados = new HashSet<>();
        No noOrigem = grafo.getNo(origem);
        
        for (No no : grafo.getNos().values()) {
            distancias.put(no, Integer.MAX_VALUE);
        }
        distancias.put(noOrigem, 0);
        filaPrioridade.add(new NoDistancia(noOrigem, 0));
        
        while (!filaPrioridade.isEmpty()) {
            NoDistancia noAtual = filaPrioridade.poll();
            if (visitados.contains(noAtual.getNo())) continue;
            visitados.add(noAtual.getNo());

            for (var aresta : noAtual.getNo().getArestas()) {
                No vizinho = aresta.getDestino();
                int novaDistancia = distancias.get(noAtual.getNo()) + aresta.getPeso();
                if (novaDistancia < distancias.get(vizinho)) {
                    distancias.put(vizinho, novaDistancia);
                    filaPrioridade.add(new NoDistancia(vizinho, novaDistancia));
                }
            }
        }
        return distancias;
    }

    private static class NoDistancia {
        private final No no;
        private final int distancia;

        public NoDistancia(No no, int distancia) {
            this.no = no;
            this.distancia = distancia;
        }

        public No getNo() {
            return no;
        }

        public int getDistancia() {
            return distancia;
        }
    }
}
