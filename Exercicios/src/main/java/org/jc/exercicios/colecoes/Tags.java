/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.colecoes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jean
 */
public class Tags {

    private final String list;
    private final String delimiter;

    public Tags(String tgs, String dlmtr) {
        this.list = valid(tgs);
        this.delimiter = valid(dlmtr);
    }

    public Tags(String tgs) {
        this(tgs, ":");
    }

    public List<String> toList() {
        List<String> resultado;
        if (this.list.isEmpty()) {
            resultado = Collections.emptyList();
        } else if (this.delimiter.isEmpty()) {
            resultado = Arrays.asList(this.list);
        } else {
            resultado = Arrays.asList(list.split(delimiter));
        }
        return resultado;
    }

    public Tags inclui(String tag) {
        final StringBuilder novas = new StringBuilder(this.list);
        novas.append(this.delimiter).append(tag);
        return new Tags(novas.toString(), this.delimiter);
    }

    private static String valid(String str) {
        return Optional.ofNullable(str).orElse("").trim();
    }
}
