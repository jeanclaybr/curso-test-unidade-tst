/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.junit.dataprovider.example;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author jean
 */
@RunWith(DataProviderRunner.class)
public class DataProviderFromOtherLocationTest {
    @Test
    @UseDataProvider(value = "dataProviderIsStringLengthGreaterTwo",
                     location = StringDataProvider.class)
    public void testIsStringLengthGreaterThanTwo(String str, boolean expected) {
        // When:
        boolean isGreaterThanTwo = (str == null) ? false : str.length() > 2;
        // Then:
        assertThat(isGreaterThanTwo, is(expected));
    }
}
