/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.download;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

/**
 *
 * @author jean
 */
public class DownloadServletTest {
    
    @Rule
    public final TemporaryFolder temp = new TemporaryFolder();
    
    private File dir;
    
    public DownloadServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        dir = temp.newFolder();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class DownloadServlet.
     */
    @Test
    public void obtemConteudoDeUmaNotaFiscal() throws Exception {
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
        final String identificacao = "00001111222244";
        File diretorio = new File(dir, identificacao);
        diretorio.mkdir();
        File arquivo = new File(diretorio, "2001-01-20_20.xml");
        arquivo.createNewFile();
        System.setProperty("nfe.dir", dir.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(arquivo);
        fileWriter.append("teste");
        fileWriter.flush();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        
        Mockito.when(req.authenticate(resp)).thenReturn(Boolean.TRUE);
        Mockito.when(req.getParameter("cpf_cnpj")).thenReturn(identificacao);
        Mockito.when(req.getParameter("dt_emissao")).thenReturn("2001-01-20");
        Mockito.when(req.getParameter("num_nf")).thenReturn("20");
        Mockito.when(resp.getWriter()).thenReturn(printWriter);
        
        DownloadServlet instance = new DownloadServlet();
        instance.doGet(req, resp);
        assertEquals("teste", stringWriter.toString());
        Mockito.verify(resp).setStatus(HttpServletResponse.SC_OK);
    }
    
    
    
}
