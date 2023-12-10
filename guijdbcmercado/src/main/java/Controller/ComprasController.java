package Controller;

import java.util.List;
import java.util.ArrayList;

import Connection.ComprasDAO;

class Compras {
    private String nome;
    private String quantidade;

    public Compras(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }
}
public class ComprasController {
    private List<Compras> comprado;

    public ComprasController() {
        comprado = new ArrayList<>();
    }

    public void adicionarProduto(String nome, String quantidade) {
        comprado.add(new Compras(nome, quantidade));
    }

    public List<Compras> getProdutosNoCarrinho() {
        return comprado;
    }

   
    public void imprimirProdutosNoCarrinho() {
        System.out.println("Produtos no Carrinho:");
        for (Compras compra : comprado) {
            System.out.println("Nome: " + compra.getNome() +", Quantidade: " + compra.getQuantidade());
        }
    }

    public static void main(String[] args) {
        ComprasController novaCompra = new ComprasController();

        // Exemplo de utilização: Adicionando produtos ao carrinho
        novaCompra.adicionarProduto("Produto 1", "2");
        novaCompra.adicionarProduto("Produto 2", "1");

        // Exibindo os produtos no carrinho (pode ser substituído pela lógica da sua view)
        novaCompra.imprimirProdutosNoCarrinho();
    }
}