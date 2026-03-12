// Arquivo: src/main/java/CalculadoraCompra.java
import java.util.List;

public class CalculadoraCompra {

    /**
     * Calcula o valor final de uma compra.
     * @param precos Lista com os preços de cada item.
     * @param desconto O valor do desconto a ser aplicado.
     * @return O valor final da compra.
     */
    public double calcular(List<Double> precos, double desconto) {
        // 1. Valida as entradas para evitar erros
        if (precos == null || precos.isEmpty()) {
            throw new IllegalArgumentException("A lista de preços não pode ser vazia.");
        }
        if (desconto < 0) {
            throw new IllegalArgumentException("O valor do desconto não pode ser negativo.");
        }

        // 2. Soma o preço de todos os itens
        double totalItens = 0.0;
        for (double preco : precos) {
            if (preco < 0) {
                throw new IllegalArgumentException("O preço de um item não pode ser negativo.");
            }
            totalItens += preco;
        }

        // 3. Subtrai o desconto, se ele for maior que zero
        double valorFinal = totalItens;
        if (desconto > 0) {
            valorFinal -= desconto;
        }

        // 4. Retorna o resultado
        return valorFinal;
    }
}