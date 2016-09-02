/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.expr;

import java.util.Arrays;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.jc.exercicios.expr.Nodo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author jean
 */
@RunWith(Parameterized.class)
public class ExpressionTest {
    
    @Parameterized.Parameters
    public static Iterable<Object[]> expressoes() {
        return Arrays.asList(new Object[][]{
            {"1 + 2 * 3", 7},
            {"1 + 2 * 3 * 3", 19},
            {"1 + 2 + 3", 6},
            {"2", 2},
            {"1 + 2", 3},
            {"2 * 3", 6},
            {"2 * 2 * 3", 12},
        });
    }
    
    private final String expressao;
    private final int esperado;

    public ExpressionTest(String expressao, int esperado) {
        this.expressao = expressao;
        this.esperado = esperado;
    }
  
    @Test
    public void calculaValorDaExpressao() {
        CharStream input = new ANTLRInputStream(expressao);
        Expression instance = new Expression();
        Nodo result = instance.build(input);
        assertEquals(esperado, result.avalia());
    }
    
}
