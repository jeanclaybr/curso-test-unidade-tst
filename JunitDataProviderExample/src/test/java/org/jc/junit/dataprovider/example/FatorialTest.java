/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.junit.dataprovider.example;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author jean
 */
@RunWith(DataProviderRunner.class)
public class FatorialTest {
    
    private static final AtomicInteger ATOMIC = new AtomicInteger(0);

    @DataProvider
    public static Object[][] dataProviderFatorial() {
        return new Object[][]{
            {0L, 1L},
            {1L, 1L},
            {2L, 2L},
            {3L, 6L},
            {4L, 24L},
            {5L, 120L},
        };
    }

    @Test
    @UseDataProvider("dataProviderFatorial")
    public void calculaFatorialDeUmNUmero(long numero, long esperado) {
        System.out.println(String.format("fatorial(%d) = %d", numero, esperado));
        Fatorial instance = new Fatorial();
        long resultado = instance.calcula(numero);
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void semDataProvider() {
        System.out.println("Sem data provider: " + ATOMIC.incrementAndGet());
    }

}
