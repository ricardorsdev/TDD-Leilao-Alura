package br.com.msmlabs.tdd_leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {

    @Test
    public void getDescricao_QuandoRecebeDescricao_DevolveDescricao() {
        // criar cenário de teste
        Leilao console = new Leilao("Console");

        // executar ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance_QuandoRecebeApenasUmLance_DevolveMaiorLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));

        double maiorLanceDevolvidoDoConsole = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoConsole, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente_DevolveMaiorLance(){
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvidoDoComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvidoDoComputador, 0.0001);
    }

    @Test
    public void getMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente_DevolveMaiorLance(){
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.0));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvidoDoCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvidoDoCarro, 0.0001);
    }
}