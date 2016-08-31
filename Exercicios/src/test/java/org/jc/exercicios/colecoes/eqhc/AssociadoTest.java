/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.exercicios.colecoes.eqhc;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Predicate;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Test;

/**
 *
 * @author jean
 */
public class AssociadoTest {

    @Test
    public void filtraDependentesPorParteDoNome() {
        System.out.println("filtraDependentesPor");
        Predicate<Dependente> predicado = new Dependente.NomeContem("pje");
        final LocalDate agora = LocalDate.now();
        Associado instance = new Associado(1L,"jean pje", "999.999.999-88", "17777771717", agora, agora);
        
        instance.incluiDependente("Jeanzinho", agora);
        Dependente dependente = new Dependente(instance, "pje", agora);
        instance.incluiDependente("pje", agora);
        instance.incluiDependente("Teste", agora);
        
        Collection<Dependente> result = instance.filtraDependentesPor(predicado);
        
        Assertions.assertThat(result).hasSize(1).containsExactly(dependente);
        Assertions.assertThat(result)
            .extracting("nome", "nascimento")
            .contains(new Tuple("pje", agora));
    } 

    @Test
    public void verificaContratoEqualsHashCode() {
        Associado kirk = new Associado(
            1L,
            "Teste",
            "12345",
            "54321",
            LocalDate.MIN,
            LocalDate.MIN
        );
        Dependente spock = new Dependente(kirk, "Spock", LocalDate.MIN);
        Dependente uhura = new Dependente(kirk, "Uhura", LocalDate.MIN);
        EqualsVerifier.forClass(Associado.class)
            /*
             * Necessário quando a estrutura de dados é recursiva A -> B -> A
             * Ver: http://jqno.nl/equalsverifier/errormessages/recursive-datastructure/
             */
           .withPrefabValues(Dependente.class, uhura, spock)
            /*
             * Ignora campos não utilizados em equals/hashCode
             */
            .withIgnoredFields("dependentes")
            .verify();
    }
    
    
}
