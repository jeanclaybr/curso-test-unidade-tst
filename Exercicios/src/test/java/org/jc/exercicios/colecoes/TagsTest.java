package org.jc.exercicios.colecoes;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class TagsTest {

    @Test
    public void retornaListaVaziaParaStringVaziaNoConstrutor() {
        Tags instance = new Tags("");
        List<String> result = instance.toList();
        assertTrue("Esperada lista vazia, mas foi: " + result,
            result.isEmpty());
    }

    @Test
    public void retornaListaVaziaParaStringNulaNoConstrutor() {
        Tags instance = new Tags(null);
        List<String> result = instance.toList();
        assertTrue("Esperada lista vazia, mas foi: " + result,
            result.isEmpty());
    }

    @Test
    public void retornaListaVaziaParaStringEmBrabcoNoConstrutor() {
        Tags instance = new Tags("       ");
        List<String> result = instance.toList();
        assertTrue("Esperada lista vazia, mas foi: " + result,
            result.isEmpty());
    }

    @Test
    public void retornaListaVaziaParaStringCompostaApenasPeloDelimitadorConstrutor() {
        Tags instance = new Tags("AAA", "A");
        List<String> result = instance.toList();
        assertTrue("Esperada lista vazia, mas foi: " + result,
            result.isEmpty());
    }

    @Test
    public void retornaListaComUmElementoParaDelimitadorVazio() {
        Tags instance = new Tags("A:B:C", "");
        List<String> esperada = Arrays.asList("A:B:C");
        List<String> result = instance.toList();
        assertEquals(esperada, result);
    }
    
        @Test
    public void retornaListaComUmElementoParaDelimitadorNulo() {
        Tags instance = new Tags("A:B:C", null);
        List<String> esperada = Arrays.asList("A:B:C");
        List<String> result = instance.toList();
        assertEquals(esperada, result);
    }

    @Test
    public void retornaListaBaseadaNoDelimitadorPadrao() {
        Tags instance = new Tags("A:B:C");
        List<String> esperada = Arrays.asList("A", "B", "C");
        List<String> result = instance.toList();
        assertEquals(esperada, result);
    }

    @Test
    public void retornaListaBaseadaEmDelimitadorEscolhido() {
        Tags instance = new Tags("ATBTC", "T");
        List<String> esperada = Arrays.asList("A", "B", "C");
        List<String> result = instance.toList();
        assertEquals(esperada, result);
    }
}
