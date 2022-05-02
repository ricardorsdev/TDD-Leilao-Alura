package br.com.msmlabs.tdd_leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {

    @Test
    public void getDescricao() {
        // criar cenário de teste
        Leilao console = new Leilao("Consoles");

        // executar ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance() {
        //verifica se devolve maior lance com apenas um lance
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));

        double maiorLanceDevolvidoDoConsole = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoConsole, 0.0001);

        //verifica se devolve maior lance com mais de um lance em ordem crescente
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvidoDoComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoComputador, 0.0001);

        //verifica se devolve maior lance com mais de um lance em ordem decrescente
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.0));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvidoDoCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvidoDoCarro, 0.0001);
    }
}