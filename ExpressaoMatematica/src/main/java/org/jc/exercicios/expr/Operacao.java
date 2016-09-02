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
public abstract class Operacao implements Nodo {
    private final Nodo esquerda;
    private final Nodo direita;

    public Operacao(Nodo esquerda, Nodo direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

   
    @Override
    public final int avalia() {
        return executa(this.esquerda.avalia(), this.direita.avalia());
    }
    
    protected abstract int executa(int esquerda, int direita);
    
    protected abstract String simbolo();

    @Override
    public String toString() {
        return  "(" + esquerda + " " + simbolo() + " " + direita + ")";
    }
    
    
    
}
