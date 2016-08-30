/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.excecoes;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import java.net.MalformedURLException;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

/**
 *
 * @author jean
 */
public class PaginaTest {

    @Rule
    public final TestName name = new TestName();

    @Rule
    public WireMockRule wmr = new WireMockRule(8787);
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void imprimeNomeTeste() {
        System.out.println(name.getMethodName());
    }

    @Test
    public void falhaComUrlMalFormadaUsandoExpectedExceptionRule() throws Exception {
        thrown.expect(DownloadException.class);
        thrown.expectCause(Matchers.instanceOf(MalformedURLException.class));
        thrown.expectMessage("O dendereço informado não é válido: \"htt://xpto.com\"");
        Pagina pagina = new Pagina("htt://xpto.com");
        pagina.download();
    }
    
    @Test(expected = DownloadException.class)
    public void falhaComUrlMalFormadaUsandoAtributoExpected() throws Exception {
        Pagina pagina = new Pagina("htt://xpto.com");
        pagina.download();
    }
    
    @Test
    public void falhaComUrlMalFormada() throws Exception {
        Pagina pagina = new Pagina("htt://xpto.com");
        Throwable throwable = Assertions.catchThrowable(() -> pagina.download());
        Assertions.assertThat(throwable)
            .hasCauseInstanceOf(MalformedURLException.class)
            .isInstanceOf(DownloadException.class)
            .hasMessage("O dendereço informado não é válido: \"htt://xpto.com\"");
    }

    @Test
    public void fazDownloadDePaginaHttp() throws Exception {
        final String body = "Run to the hills";

        stubFor(get(urlMatching("/teste"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody(body)));
        Pagina instance = new Pagina(
            "http://localhost:" + wmr.port() + "/teste"
        );
        String result = instance.download();
        Assertions.assertThat(result).isEqualTo(body);
    }

}
