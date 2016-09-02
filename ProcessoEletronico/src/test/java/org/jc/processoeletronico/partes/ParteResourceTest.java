/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.processoeletronico.partes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import net.javacrumbs.jsonunit.fluent.JsonFluentAssert;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author jean
 */
public class ParteResourceTest {

    private String esperado;
    private String desordenado;
    private EntityManager dao;
    private Query query;

    public ParteResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        InputStream input = Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("polo/json/resposta.json");
        esperado = org.apache.commons.io.IOUtils.toString(input);
        InputStream entrada = Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream("polo/json/entrada.json");
        desordenado = org.apache.commons.io.IOUtils.toString(entrada);
        dao = Mockito.mock(EntityManager.class);
        query = Mockito.mock(Query.class);
        Mockito
            .when(dao.createQuery(Mockito.anyString()))
            .thenReturn(query);
        Mockito
            .when(query.setParameter(Mockito.anyString(), Mockito.anyLong()))
            .thenReturn(query);
        Mockito
            .when(query.getResultList())
            .thenReturn(criaListaDoJson());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void retornaPoloParteDoProcessoOrdenado() {
        long proc = 1L;
        ParteResource resource = new ParteResource(dao);

        Response resposta = resource.partesOrdenadas(proc);
        String conteudo = resposta.getEntity().toString();
        System.out.println(conteudo);
        Assertions.assertThat(resposta.getStatus())
            .isEqualTo(Response.Status.OK.getStatusCode());
        JsonFluentAssert
            .assertThatJson(conteudo)
            .isEqualTo(esperado);
    }
    
    
    @Test
    public void deJsonParaJava() {
        Gson gson = new GsonBuilder().create();
        List<Sujeito> fromJson = gson.fromJson(esperado, List.class);
        System.out.println(fromJson);
    }

    private List<Sujeito> criaListaDoJson() {
        return new GsonBuilder().create().fromJson(desordenado, List.class);
    }
    
    private List<Sujeito> criaLista() {
        List<Sujeito> polos = new ArrayList<>();
        polos.add(
            new Sujeito(
                Sujeito.Polo.ativo,
                Arrays.asList(
                    new Advogado(
                        "123456-DF",
                        "Tomás",
                        Advogado.Status.principal
                    )
                ),
                Arrays.asList(new Parte("145.689.895-44", "James T. Kirk"))
            )
        );
        polos.add(
            new Sujeito(
                Sujeito.Polo.passivo,
                Arrays.asList(
                    new Advogado(
                        "223456-DF",
                        "Tiberius",
                        Advogado.Status.principal
                    )
                ),
                Arrays.asList(new Parte("785.689.895-44", "Jean Luc Picard"))
            )
        );
        return polos;
    }

}
