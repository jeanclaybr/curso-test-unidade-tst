/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.junit.dataprovider.example;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Ver https://github.com/TNG/junit-dataprovider/wiki/Features
 * @author jean
 */
@RunWith(DataProviderRunner.class)
public class FileDataProviderTest {
    @DataProvider
    public static String[] dataProviderFileExistence() {
        // @formatter:off
        return new String[] {
                "src,             true",
                "src/main,        true",
                "src/main/java/,  true",
                "src/test/java/,  true",
                "test,            false",
        };
        // @formatter:on
    }

    @Test
    @UseDataProvider("dataProviderFileExistence")
    public void testFileExistence(File file, boolean expected) {
        // Expect:
        assertEquals(expected, file.exists());
    }
    
    @Test
    @DataProvider(value = {
        "src              |  true",
        "src/main         |  true",
        "src/main/java/   |  true",
        "src/test/java/   |  true",
        "test             |  false",
    }, splitBy = "\\|", trimValues = true)
    public void usandoDadosNaAnotacaoDoMetodo(File file, boolean expected) {
        // Expect:
        assertEquals(expected, file.exists());
    }
}
