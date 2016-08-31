/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.expr;

/**
 *
 * @author jean
 */
public class Soma implements Nodo {

    private final Nodo esquerda;
    private final Nodo direita;

    public Soma(Nodo esquerda, Nodo direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int avalia() {
        return this.esquerda.avalia()
            + this.direita.avalia();
    }

}
