/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.expr;

import java.util.Stack;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jc.antlr.expr.ExprBaseListener;
import org.jc.antlr.expr.ExprParser;
import org.jc.exercicios.expr.Multiplicacao;
import org.jc.exercicios.expr.Nodo;
import org.jc.exercicios.expr.Soma;
import org.jc.exercicios.expr.Valor;

/**
 *
 * @author jean
 */
public class DefaultExprListener extends ExprBaseListener {
    private final ExprParser parser;
    private final Stack<String> valores = new Stack<>();
    private final Stack<String> operacoes = new Stack<>();
    private final Stack<Nodo> nodos = new Stack<>();

    public DefaultExprListener(ExprParser parser) {
        this.parser = parser;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        final String item = node.toString();
        if(isOperacao(item)) {
            operacoes.push(item);
        } else {
            nodos.push(new Valor(Integer.valueOf(item)));
        }
//        if(nodos.size() == 2  && operacoes.size() >= 1) {
//            Nodo direita = nodos.pop();
//            Nodo esquerda = nodos.pop();
//            nodos.push(criaOperacao(operacoes.remove(0), direita, esquerda));
//        }
        System.out.println("Terminal node: " + node);
    }
    
    
    
    public Nodo root() {
        System.out.println(nodos);
        System.out.println(operacoes);
        
        while(!operacoes.isEmpty()) {
            nodos.push(criaOperacao(operacoes.pop(), nodos.pop(), nodos.pop()));
        }
        
        return nodos.pop();
    }

    private boolean isOperacao(String item) {
        return !item.matches("\\d+");
    }

    private Nodo criaOperacao(String item, Nodo direita, Nodo esquerda) {
        Nodo op;
        System.out.println(">" + item + "<");
        if("*".equals(item)) {
            op = new Multiplicacao(esquerda, direita);
        } else {
            op = new Soma(esquerda, direita);
        }
        return op;
    }
}
