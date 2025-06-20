/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aestrela;

import static aestrela.ValeDoItajai.verificaCidade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author oliveira.pedro
 */
public class Main {
    public static void main(String[] args) {
         // Criar o grafo do Vale do Itajaí
        ValeDoItajai grafo = new ValeDoItajai();
        
        // Criar o objeto AEstrela para calcular a melhor rota
        AEstrela aEstrela = new AEstrela(grafo);
        
        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitar a cidade de origem
        System.out.print("Digite a cidade de origem: ");
        String cidadeOrigem = verificaCidade(scanner, grafo);

        // Solicitar a cidade de destino
        System.out.print("Digite a cidade de destino: ");
        String cidadeDestino = verificaCidade(scanner, grafo);

        // Calcular a melhor rota
        List<String> melhorRota = aEstrela.encontrarCaminho(cidadeOrigem, cidadeDestino);
        
        // Verificar se foi encontrada uma rota
        if (melhorRota.isEmpty()) {
            System.out.println("Não foi possível encontrar uma rota entre as cidades especificadas.");
        } else {
            // Exibir a melhor rota
            System.out.println("Melhor rota:");
            for (String cidade : melhorRota) {
                System.out.println("- " + cidade);
            }
        }
        
        // Fechar o scanner
        scanner.close();
}
}
       
