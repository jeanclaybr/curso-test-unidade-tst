/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.processoeletronico.partes;

import java.util.List;

/**
 *
 * @author jean
 */
public class Sujeito {
    public static enum Polo {ativo, passivo}
    private final Polo polo;
    private final List<Advogado> advogados;
    private final List<Parte> partes;

    public Sujeito(Polo polo, List<Advogado> advogados, List<Parte> partes) {
        this.polo = polo;
        this.advogados = advogados;
        this.partes = partes;
    }

}
