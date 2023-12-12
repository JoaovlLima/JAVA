package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;
import Connection.ProdutosDAO;
import Exception.*;

public class ProdutosController {
    private List<Produtos> produtos;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ProdutosController(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Gets and Sets
    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setCarros(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;

        new ProdutosDAO().criaTabela();
        atualizarTabelaProd();
    }

    private void atualizarTabelaProd() {
        tableModel.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[] { produto.getNome(), produto.getCodigo(), produto.getDescricao(),
                    produto.getPreco(), produto.getQuantidade() });
        }

    }

    public void cadastrar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {
        try {
            if (!(nome.isEmpty() || Codigo.isEmpty() || Descricao.isEmpty() || Preco.isEmpty()
                    || Quantidade.isEmpty())) {
                int verificarCodigo = Integer.parseInt(Codigo);
                int verificarQtde = Integer.parseInt(Quantidade);
                if (verificarCodigo >= 1000) {
                    produtos = new ProdutosDAO().listarTodos();
                    boolean codigoJaExiste = false;

                    for (Produtos produto : produtos) {
                        if (verificarCodigo == Integer.parseInt(produto.getCodigo())) {
                            codigoJaExiste = true;
                            break; // O código já está cadastrado, então podemos parar de procurar
                        }
                    }

                    if (!codigoJaExiste) {
                        new ProdutosDAO().cadastrar(nome, Codigo, Descricao, Preco, Quantidade);
                        atualizarTabelaProd();
                    } else {
                        throw new CodeFormatException("Código já existe. Por favor, utilize um código diferente.");
                    }
                } else {
                    throw new CodeFormatException(
                            "Código Inválido. Por favor, preencha um código válido acima de 1000.");
                }
            } else {
                throw new NullPointerException("Informações inválidas. Por favor, preencha as informações vazias.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                    "Informações Inválidas. Por favor, preencha utilizando somente números.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (CodeFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro não identificado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void apagar(String codigo) {
        try {
            if (!(codigo.isEmpty())) {
                new ProdutosDAO().apagar(codigo);
                atualizarTabelaProd();
            } else {
                throw new NullPointerException("Erro de Seleção, por favor selecione uma linha.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro não identificado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {
        try {

            if (!(nome.isEmpty() || Codigo.isEmpty()
                    || Descricao.isEmpty() || Preco.isEmpty()
                    || Quantidade.isEmpty())) {
                new ProdutosDAO().atualizar(nome, Codigo, Descricao, Preco, Quantidade);
                atualizarTabelaProd();
            } else {
                throw new NullPointerException("Informações inválidas. Por favor preencha as informações vazias.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro não identificado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {

        atualizarTabelaProd();
    }
}
