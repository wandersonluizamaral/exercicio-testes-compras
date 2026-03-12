// Arquivo: src/test/java/CalculadoraCompraTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

public class CalculadoraCompraTest {

    private final CalculadoraCompra calculadora = new CalculadoraCompra();

    @Test
    void deveCalcularValorFinalComDesconto() {
        // Teste de sucesso: 50 + 30 = 80. Desconto de 10. Resultado = 70.
        double valorFinal = calculadora.calcular(List.of(50.0, 30.0), 10.0);
        assertEquals(70.0, valorFinal);
    }

    @Test
    void deveCalcularValorFinalSemDesconto() {
        // Teste de sucesso: 25 + 75 = 100. Desconto de 0. Resultado = 100.
        double valorFinal = calculadora.calcular(List.of(25.0, 75.0), 0.0);
        assertEquals(100.0, valorFinal);
    }

    @Test
    void deveLancarExcecaoParaListaDePrecosVazia() {
        // Teste de erro: lista vazia
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(Collections.emptyList(), 5.0);
        });
    }

    @Test
    void deveLancarExcecaoParaListaDePrecosNula() {
        // Teste de erro: lista nula
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(null, 5.0);
        });
    }

    @Test
    void deveLancarExcecaoParaPrecoInvalido() {
        // Teste de erro: preço negativo na lista
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(List.of(100.0, -10.0, 50.0), 20.0);
        });
    }

    @Test
    void deveLancarExcecaoParaDescontoInvalido() {
        // Teste de erro: desconto negativo
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(List.of(100.0, 50.0), -20.0);
        });
    }
}