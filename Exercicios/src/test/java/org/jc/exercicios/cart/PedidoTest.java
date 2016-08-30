/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.cart;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class PedidoTest {
    
    public PedidoTest() {
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

   

    /**
     * Test of total method, of class Pedido.
     */
    @Test
    public void calculaTotalSemDesconto() {
        System.out.println("total");
        Desconto desconto = new Desconto() {
            @Override
            public BigDecimal calcula(BigDecimal valor) {
                return BigDecimal.ZERO;
            }
        };
        Pedido instance = new Pedido();
        instance.inclui(new Item(2, BigDecimal.TEN));
        instance.inclui(new Item(3, BigDecimal.TEN));
        BigDecimal expResult = BigDecimal.valueOf(50);
        BigDecimal result = instance.total(desconto);
        assertEquals(expResult, result);
    }
    
}
