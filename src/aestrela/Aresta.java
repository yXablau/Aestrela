/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aestrela;

/**
 *
 * @author oliveira.pedro
 */
public class Aresta {
    private String destino;
    private double distancia;

    public Aresta(String destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
   
}
