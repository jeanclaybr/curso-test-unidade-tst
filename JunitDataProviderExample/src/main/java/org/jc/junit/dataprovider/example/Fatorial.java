/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.junit.dataprovider.example;

/**
 *
 * @author jean
 */
public class Fatorial {
    public long calcula(long numero) {
        if(numero == 0) {
            return 1;
        } else {
            long acumulador = 1;
            for(long cont = 1; cont <= numero; cont++) {
                acumulador *= cont;
            }
            return acumulador;
        }
    }
}
