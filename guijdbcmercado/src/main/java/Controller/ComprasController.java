package Controller;

import java.util.List;
import java.util.ArrayList;

import Connection.ProdutosDAO;

class Compras {
    private String codigo;
    private String quantidade;

    public Compras(String codigo, String quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getQuantidade() {
        return quantidade;
    }
}

public class ComprasController {
    private List<Compras> comprado;
    private ProdutosDAO produtosDAO; // Movido para o escopo da classe

    public ComprasController() {
        comprado = new ArrayList<>();
        produtosDAO = new ProdutosDAO(); // Inicialização aqui
    }

    public void adicionarProduto(String codigo, String quantidade) {
        comprado.add(new Compras(codigo, quantidade));
    }

    public List<Compras> getProdutosNoCarrinho() {
        return comprado;
    }

    public void imprimirProdutosNoCarrinho() {
        System.out.println("Produtos no Carrinho:");
        for (Compras compra : comprado) {
            System.out.println("codigo: " + compra.getCodigo() + ", Quantidade: " + compra.getQuantidade());
        }
    }

    public void atualizarQuantidadesNoBanco() {
        for (Compras compra : comprado) {
            String codigoProduto = compra.getCodigo();
            String quantidadeComprada = compra.getQuantidade();

            // Obtém a quantidade atual do produto no banco de dados
            int quantidadeAtual = produtosDAO.obterQuantidade(codigoProduto);

            // Verifica se há estoque suficiente para a compra
            if (quantidadeAtual >= Integer.parseInt(quantidadeComprada)) {
                // Calcula a nova quantidade após a compra
                int novaQuantidade = quantidadeAtual - Integer.parseInt(quantidadeComprada);

                // Atualiza a quantidade no banco de dados
                produtosDAO.atualizarQuantidade(codigoProduto,String.valueOf(novaQuantidade));
            } else {
                System.out.println("Estoque insuficiente para o produto: " + codigoProduto);
                // Aqui você pode lidar com a situação de estoque insuficiente, se necessário
            }
        }
    }

    public static void main(String[] args) {
        ComprasController novaCompra = new ComprasController();

        // Exemplo de utilização: Adicionando produtos ao carrinho
        novaCompra.adicionarProduto("1001", "2");
        

        // Exibindo os produtos no carrinho (pode ser substituído pela lógica da sua view)
        novaCompra.imprimirProdutosNoCarrinho();

        // Atualizar as quantidades no banco de dados
        novaCompra.atualizarQuantidadesNoBanco();
    }
}
