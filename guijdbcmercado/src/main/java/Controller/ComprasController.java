package Controller;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashMap;

import Connection.ProdutosDAO;
import Model.Produtos;
import View.ComprasPainel;
import Exception.*;

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
    private List<Produtos> produtos;
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

    // public void imprimirProdutosNoCarrinho() {
    //     System.out.println("Produtos no Carrinho:");
    //     for (Compras compra : comprado) {
    //         System.out.println("codigo: " + compra.getCodigo() + ", Quantidade: " + compra.getQuantidade());
    //     }
    // }

    public void atualizarQuantidadesNoBanco(String codigo) {
        try {
            // Obtendo a lista de produtos no carrinho
            List<Compras> comprasNoCarrinho = getProdutosNoCarrinho();

            // Verificando se há produtos no carrinho antes de prosseguir
            if (comprasNoCarrinho.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Seu carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                return; // Retorna se o carrinho estiver vazio
            }

            // Itera sobre os produtos no carrinho para atualizar as quantidades no banco
            for (Compras compra : comprasNoCarrinho) {

                String codigoProduto = compra.getCodigo();
                int quantidadeComprada = Integer.parseInt(compra.getQuantidade());

                // Obtém a quantidade atual do produto no banco de dados
                int quantidadeAtual = produtosDAO.obterQuantidade(codigoProduto);

                // Verifica se há estoque suficiente para a compra
                if (quantidadeComprada != 0) {
                    if (quantidadeAtual >= quantidadeComprada) {
                        int novaQuantidade = quantidadeAtual - quantidadeComprada;

                        // // Atualiza a quantidade no banco de dados
                        produtosDAO.atualizarQuantidade(codigoProduto,
                                String.valueOf(novaQuantidade));
                    } else {
                        System.out.println("Estoque insuficiente para o produto: " + codigoProduto);
                        // // Lógica para lidar com estoque insuficiente, se necessário
                    }
                } else {
                    throw new QuantityFormatExeception("Quantidade inválidada, por favor selecione um valor válido");
                }
            }

            ComprasPainel comprasPainel = new ComprasPainel(); // Instancia a classe ComprasPainel (ou use a instância
                                                               // existente, se aplicável)
            comprasPainel.atualizarTabelaProd(); // Chama o método para atualizar a tabela na classe ComprasPainel
        } catch (QuantityFormatExeception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }

}