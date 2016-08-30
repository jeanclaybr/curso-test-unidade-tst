/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.junit.dataprovider.example;

import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 *
 * @author jean
 */
public class StringDataProvider {
    @DataProvider
    public static Object[][] dataProviderIsStringLengthGreaterTwo() {
        // @formatter:off
        return new Object[][] {
                { "",       false },
                { "1",      false },
                { "12",     false },
                { "123",    true },
                { "Test",   true },
            };
        // @formatter:on
    }
}
