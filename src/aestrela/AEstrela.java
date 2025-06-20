/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aestrela;

import java.util.*;

/**
 *
 * @author oliveira.pedro
 */
public class AEstrela {
    private ValeDoItajai grafo;

    public AEstrela(ValeDoItajai grafo) {
        this.grafo = grafo;
    }

    public List<String> encontrarCaminho(String cidadeOrigem, String cidadeDestino) {
        // Conjunto de nós a serem avaliados
        Set<String> abertos = new HashSet<>();
        // Conjunto de nós já avaliados
        Set<String> fechados = new HashSet<>();
        // Mapeamento para recuperar o nó pai de um nó
        Map<String, String> pais = new HashMap<>();
        // Mapeamento para armazenar os custos acumulados dos nós
        Map<String, Double> custos = new HashMap<>();

        // Inicialização dos valores para a cidade de origem
        abertos.add(cidadeOrigem);
        custos.put(cidadeOrigem, 0.0);

        while (!abertos.isEmpty()) {
            // Escolher o nó com o menor custo total
            String cidadeAtual = obterMenorCusto(abertos, custos);
            if (cidadeAtual.equals(cidadeDestino)) {
                // Reconstruir o caminho e retornar
                return reconstruirCaminho(cidadeOrigem, cidadeDestino, pais);
            }

            // Remover o nó atual do conjunto aberto e adicioná-lo ao conjunto fechado
            abertos.remove(cidadeAtual);
            fechados.add(cidadeAtual);

            // Expandir o nó atual e adicionar seus vizinhos ao conjunto aberto
            for (Aresta aresta : grafo.obterVizinhos(cidadeAtual)) {
                String vizinho = aresta.getDestino();
                if (fechados.contains(vizinho)) {
                    continue; // Vizinho já avaliado
                }

                // Calculando o custo acumulado até o vizinho
                double novoCusto = custos.get(cidadeAtual) + aresta.getDistancia();
                if (!abertos.contains(vizinho) || novoCusto < custos.getOrDefault(vizinho, Double.POSITIVE_INFINITY)) {
                    pais.put(vizinho, cidadeAtual);
                    custos.put(vizinho, novoCusto);
                    abertos.add(vizinho);
                }
            }
        }

        // Não foi possível encontrar um caminho
        return new ArrayList<>();
    }

    private String obterMenorCusto(Set<String> abertos, Map<String, Double> custos) {
        String menorCustoCidade = null;
        double menorCusto = Double.POSITIVE_INFINITY;
        for (String cidade : abertos) {
            double custo = custos.getOrDefault(cidade, Double.POSITIVE_INFINITY);
            if (custo < menorCusto) {
                menorCusto = custo;
                menorCustoCidade = cidade;
            }
        }
        return menorCustoCidade;
    }

    private List<String> reconstruirCaminho(String cidadeOrigem, String cidadeDestino, Map<String, String> pais) {
        List<String> caminho = new ArrayList<>();
        String cidadeAtual = cidadeDestino;
        while (cidadeAtual != null) {
            caminho.add(cidadeAtual);
            cidadeAtual = pais.get(cidadeAtual);
        }
        Collections.reverse(caminho);
        return caminho;
    }
}
