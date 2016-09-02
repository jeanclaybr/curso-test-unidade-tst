/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.processoeletronico.partes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author jean
 */
public class ParteResource {
    
    @PersistenceContext
    private EntityManager dao;

    public ParteResource(EntityManager dao) {
        this.dao = dao;
    }

    public ParteResource() {
    }

    public Response partesOrdenadas(long proc) {
        Query query = dao.createQuery(
            "select polo from Polo polo where polo.proc = :procId"
        );
        List<Sujeito> polos = query.setParameter("procId", proc)
            .getResultList();
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
        Response resposta = Response.ok(gson.toJson(polos)).build();
        return resposta;
    }
    
}
