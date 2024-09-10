package com.example.grafos.algorithm;

import java.util.*;

import com.example.grafos.model.Grafo;
import com.example.grafos.model.No;

public class AStar {

    public List<No> executar(Grafo grafo, String origem, String destino, Map<No, Double> heuristica) {
        No noOrigem = grafo.getNo(origem);
        No noDestino = grafo.getNo(destino);

        Map<No, No> pais = new HashMap<>();
        Map<No, Double> gScore = new HashMap<>();
        Map<No, Double> fScore = new HashMap<>();
        PriorityQueue<NoDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(NoDistancia::getDistancia));


        for (No no : grafo.getNos().values()) {
            gScore.put(no, Double.MAX_VALUE);
            fScore.put(no, Double.MAX_VALUE);
        }
        gScore.put(noOrigem, 0.0);
        fScore.put(noOrigem, heuristica.get(noOrigem));
        filaPrioridade.add(new NoDistancia(noOrigem, fScore.get(noOrigem)));

        while (!filaPrioridade.isEmpty()) {
            NoDistancia noAtual = filaPrioridade.poll();

            if (noAtual.getNo().equals(noDestino)) {
                return construirCaminho(pais, noDestino); 
            }

            for (var aresta : noAtual.getNo().getArestas()) {
                No vizinho = aresta.getDestino();
                double tentativaGScore = gScore.get(noAtual.getNo()) + aresta.getPeso();
                if (tentativaGScore < gScore.get(vizinho)) {
                    pais.put(vizinho, noAtual.getNo());
                    gScore.put(vizinho, tentativaGScore);
                    fScore.put(vizinho, tentativaGScore + heuristica.get(vizinho));
                    filaPrioridade.add(new NoDistancia(vizinho, fScore.get(vizinho)));
                }
            }
        }

        return null; 
    }

    private List<No> construirCaminho(Map<No, No> pais, No destino) {
        List<No> caminho = new LinkedList<>();
        No atual = destino;
        while (atual != null) {
            caminho.add(0, atual);
            atual = pais.get(atual);
        }
        return caminho;
    }

    private static class NoDistancia {
        private final No no;
        private final double distancia;

        public NoDistancia(No no, double distancia) {
            this.no = no;
            this.distancia = distancia;
        }

        public No getNo() {
            return no;
        }

        public double getDistancia() {
            return distancia;
        }
    }
}
