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
public class Multiplicacao extends Operacao {

    public Multiplicacao(Nodo esquerda, Nodo direita) {
        super(esquerda, direita);
    }

    @Override
    protected int executa(int esquerda, int direita) {
        return esquerda * direita;
    }

    @Override
    protected String simbolo() {
        return "*";
    }
}
