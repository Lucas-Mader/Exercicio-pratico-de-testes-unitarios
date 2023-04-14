package br.senai.sc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {
    private ContaBancaria contaBancaria;

    @BeforeEach
    public void setUp() {
        contaBancaria = new ContaBancaria("123", "321");
    }

    @Test
    public void getNumeroContaTest() {
        assertEquals("123", contaBancaria.getNumeroConta());
    }

    @Test
    public void getTitularTest() {
        assertEquals("321", contaBancaria.getTitular());
    }

    @Test
    public void getSaldoTest() {
        contaBancaria.depositar(100);
        assertEquals(100, contaBancaria.getSaldo());
    }

    @Test
    public void getTaxaJurosTest() {
        assertEquals(0, contaBancaria.getTaxaJuros());
    }

    @Test
    public void setTaxaJurosTest() {
        contaBancaria.setTaxaJuros(2);
        assertEquals(2, contaBancaria.getTaxaJuros());
    }

    @Test
    public void depositarTest() {
        assertTrue(contaBancaria.depositar(1000));
    }

    @Test
    public void sacarTest() {
        contaBancaria.depositar(1000);
        assertTrue(contaBancaria.sacar(500));
    }

    @Test
    public void transferirTest() {
        contaBancaria.depositar(10000);
        assertTrue(contaBancaria.transferir(contaBancaria, 1000));
    }

    @Test
    public void aplicarJurosTest() {
        contaBancaria.setTaxaJuros(1);
        contaBancaria.depositar(1000);
        contaBancaria.aplicarJuros();
        assertEquals(2000, contaBancaria.getSaldo());
    }

    @Test
    public void alterarTitularTest() {
        assertTrue(contaBancaria.alterarTitular("José"));
    }
}
