/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aestrela;

import java.util.*;
/**
 * Classe representando um grafo que modela a região do Vale do Itajaí.
 */

/**
 *
 * @author oliveira.pedro
 */
public class ValeDoItajai {
    // Mapa que armazena as conexões entre cidades e suas distâncias
       private Map<String, List<Aresta>> vizinhos;

    public ValeDoItajai() {
        this.vizinhos = new HashMap<>();
        inicializarGrafo();
    }
    
    public void adicionarAresta(String cidadeOrigem, String cidadeDestino, double distancia) {
        vizinhos.computeIfAbsent(cidadeOrigem, k -> new ArrayList<>()).add(new Aresta(cidadeDestino, distancia));
        vizinhos.computeIfAbsent(cidadeDestino, k -> new ArrayList<>()).add(new Aresta(cidadeOrigem, distancia));
    }

    public List<Aresta> obterVizinhos(String cidade) {
        return vizinhos.getOrDefault(cidade, Collections.emptyList());
    }

    public Set<String> obterTodasCidades() {
        return vizinhos.keySet();
    }

    public double obterDistancia(String cidadeOrigem, String cidadeDestino) {
        for (Aresta aresta : vizinhos.getOrDefault(cidadeOrigem, Collections.emptyList())) {
            if (aresta.getDestino().equals(cidadeDestino)) {
                return aresta.getDistancia();
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    private void inicializarGrafo() {
        adicionarAresta("Blumenau", "Itajaí", 62.9);
        adicionarAresta("Blumenau", "Joinville", 99.4);
        adicionarAresta("Blumenau", "Brusque", 40.7);
        adicionarAresta("Blumenau", "Gaspar", 18.3);
        adicionarAresta("Blumenau", "Indaial", 24.8);
        adicionarAresta("Itajaí", "Joinville", 86.8);
        adicionarAresta("Itajaí", "Balneário Camboriú", 18.7);
        adicionarAresta("Itajaí", "Navegantes", 21.7);
        adicionarAresta("Joinville", "Jaraguá do Sul", 50.2);
        adicionarAresta("Joinville", "Brusque", 115);
        adicionarAresta("Joinville", "Balneário Camboriú", 99.4);
        adicionarAresta("Joinville", "São Francisco do Sul", 53.2);
        adicionarAresta("Brusque", "Balneário Camboriú", 43.1);
        adicionarAresta("Brusque", "Indaial", 66.3);
        adicionarAresta("Brusque", "Gaspar", 26.7);
        adicionarAresta("Gaspar", "Indaial", 38.4);
        adicionarAresta("Gaspar", "Timbó", 44.9);
        adicionarAresta("Indaial", "Timbó", 11.2);
        adicionarAresta("Indaial", "Rio do Sul", 74.4);
        adicionarAresta("Balneário Camboriú", "Itapema", 14);
        adicionarAresta("Balneário Camboriú", "Camboriú", 4);
        adicionarAresta("Itapema", "Navegantes", 44.3);
        adicionarAresta("Itapema", "Camboriú", 18.7);
        adicionarAresta("Navegantes", "Camboriú", 35.4);
        adicionarAresta("Jaraguá do Sul", "Pomerode", 33.6);
        adicionarAresta("Jaraguá do Sul", "Timbó", 53.2);
        adicionarAresta("São Francisco do Sul", "Joinville", 52.4);
    }
    
       // Método para verificar se a cidade fornecida pelo usuário existe no grafo
    public static String verificaCidade(Scanner scanner, ValeDoItajai grafo) {
        String cidade;
        // Loop para garantir que a cidade fornecida seja válida
        do {
            // Ler a cidade fornecida pelo usuário
            cidade = scanner.nextLine();
            // Verificar se a cidade existe no grafo
            if (!grafo.obterTodasCidades().contains(cidade)) {
                System.out.println("Cidade não encontrada. Por favor, digite uma cidade válida.");
            }
        } while (!grafo.obterTodasCidades().contains(cidade));
        
        return cidade;
    }
}
