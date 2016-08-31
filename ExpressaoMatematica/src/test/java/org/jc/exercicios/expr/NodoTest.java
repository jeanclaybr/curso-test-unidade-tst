/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.expr;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jean
 */
public class NodoTest {
    
    public NodoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void retornaDoisQuandoExpressaoForSomenteNumeroDois() {
        final int val = 2;
        Nodo nodo = new Valor(val);
        int resultado = nodo.avalia();
        Assertions.assertThat(resultado).isEqualTo(val);
    }
    
    @Test
    public void retornaTresQuandoExpressaoForSomenteNumeroTres() {
        final int val = 3;
        Nodo nodo = new Valor(val);
        int resultado = nodo.avalia();
        Assertions.assertThat(resultado).isEqualTo(val);
    }
    
    @Test
    public void retornaCincoQuandoExpressaoForDoisMaisTres() {
        Nodo direita = new Valor(2);
        Nodo esquerda = new Valor(3);
        Nodo nodo = new Soma(esquerda, direita);
        int resultado = nodo.avalia();
        Assertions.assertThat(resultado).isEqualTo(5);
    }
    
    @Test
    public void retornaDezoitoAoMultiplicarTresPorSeis() {
        Nodo direita = new Valor(3);
        Nodo esquerda = new Valor(6);
        Nodo nodo = new Multiplicacao(esquerda, direita);
        int resultado = nodo.avalia();
        
        
        Assertions.assertThat(resultado).isEqualTo(18);
    }
    
    
    @Test
    public void retornaSeteParaUmMaisDoisVezesTres() {
        Nodo direita = new Multiplicacao(new Valor(2), new Valor(3));
        Nodo esquerda = new Valor(1);
        Nodo nodo = new Soma(esquerda, direita);
        int resultado = nodo.avalia();
        Assertions.assertThat(resultado).isEqualTo(7);
    }
}
