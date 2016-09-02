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
public class Valor implements Nodo {

    private final int val;

    public Valor(int val) {
        this.val = val;
    }

    @Override
    public int avalia() {
        return this.val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
    
    
}
