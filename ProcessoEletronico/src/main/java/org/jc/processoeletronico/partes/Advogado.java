/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.processoeletronico.partes;

/**
 *
 * @author jean
 */
public class Advogado {
    public static enum Status{principal, auxiliar, estagiario}
    
    private final String oab;
    private final String nome;
    private final Status status;

    public Advogado(String oab, String nome, Status status) {
        this.oab = oab;
        this.nome = nome;
        this.status = status;
    }
    
    
}
