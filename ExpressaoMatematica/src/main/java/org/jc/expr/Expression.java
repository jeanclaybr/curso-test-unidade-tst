/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.expr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jc.antlr.expr.ExprLexer;
import org.jc.antlr.expr.ExprParser;
import org.jc.exercicios.expr.Nodo;

/**
 *
 * @author jean
 */
public class Expression {

    public Nodo build(CharStream input) {
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        DefaultExprListener extractor = new DefaultExprListener(parser);
        ParseTree tree = parser.expr();
        ParseTreeWalker.DEFAULT.walk(extractor, tree);
        return extractor.root();
    }
}
