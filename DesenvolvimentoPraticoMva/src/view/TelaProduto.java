package view;

import controller.ProdutoControle;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaProduto extends JFrame {
    private JTextField txtId, txtNome, txtCategoria, txtPreco, txtQuantEstoque;
    private JButton btnCadastrar, btnAlterar, btnRemover, btnBuscar, btnLimpar;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private ProdutoControle produtoControle;

    public TelaProduto() {
        produtoControle = new ProdutoControle();
        initComponents();
        atualizarTabela();
    }

    private void initComponents() {
        setTitle("Gestão e Cadastro de Produtos");
        setSize(750, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Formulário
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createTitledBorder("Dados do Produto"));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelForm.add(txtNome);

        panelForm.add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        panelForm.add(txtCategoria);

        panelForm.add(new JLabel("Preço (R$):"));
        txtPreco = new JTextField();
        panelForm.add(txtPreco);

        panelForm.add(new JLabel("Quantidade em Estoque:"));
        txtQuantEstoque = new JTextField();
        panelForm.add(txtQuantEstoque);

        // Painel de Botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        btnCadastrar = new JButton("Cadastrar");
        btnAlterar = new JButton("Alterar");
        btnRemover = new JButton("Remover");
        btnBuscar = new JButton("Buscar ID");
        btnLimpar = new JButton("Limpar");

        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnAlterar);
        panelBotoes.add(btnRemover);
        panelBotoes.add(btnBuscar);
        panelBotoes.add(btnLimpar);

        // Tabela de Listagem
        String[] colunas = {"ID", "Nome", "Categoria", "Preço", "Estoque"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(tabela);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelForm, BorderLayout.CENTER);
        panelSuperior.add(panelBotoes, BorderLayout.SOUTH);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollTable, BorderLayout.CENTER);

        add(panelPrincipal);

        // Configuração dos Eventos
        btnCadastrar.addActionListener(e -> cadastrarProduto());
        btnAlterar.addActionListener(e -> alterarProduto());
        btnRemover.addActionListener(e -> removerProduto());
        btnBuscar.addActionListener(e -> buscarProduto());
        btnLimpar.addActionListener(e -> limparCampos());

        // Preencher os campos ao clicar numa linha da tabela
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selecionarLinhaTabela();
            }
        });
    }

    private void cadastrarProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nome = txtNome.getText().trim();
            String categoria = txtCategoria.getText().trim();
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));
            int quantEstoque = Integer.parseInt(txtQuantEstoque.getText().trim());

            if (produtoControle.buscar(id) != null) {
                JOptionPane.showMessageDialog(this, "Já existe um produto registado com o ID informado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            produtoControle.cadastrar(id, nome, categoria, preco, quantEstoque);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            atualizarTabela();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira valores numéricos válidos nos campos ID, Preço e Estoque.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterarProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nome = txtNome.getText().trim();
            String categoria = txtCategoria.getText().trim();
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));
            int quantEstoque = Integer.parseInt(txtQuantEstoque.getText().trim());

            boolean alterou = produtoControle.alterar(id, nome, categoria, preco, quantEstoque);
            if (alterou) {
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado para alteração.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira valores numéricos válidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            boolean removeu = produtoControle.remover(id);

            if (removeu) {
                JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido para remover.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarProduto() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            Produto p = produtoControle.buscar(id);

            if (p != null) {
                txtNome.setText(p.getNome());
                txtCategoria.setText(p.getCategoria());
                txtPreco.setText(String.valueOf(p.getPreco()));
                txtQuantEstoque.setText(String.valueOf(p.getQuantEstoque()));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum produto encontrado com o ID especificado.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um ID numérico para pesquisar.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selecionarLinhaTabela() {
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            txtId.setText(tableModel.getValueAt(linha, 0).toString());
            txtNome.setText(tableModel.getValueAt(linha, 1).toString());
            txtCategoria.setText(tableModel.getValueAt(linha, 2).toString());
            txtPreco.setText(tableModel.getValueAt(linha, 3).toString());
            txtQuantEstoque.setText(tableModel.getValueAt(linha, 4).toString());
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCategoria.setText("");
        txtPreco.setText("");
        txtQuantEstoque.setText("");
        tabela.clearSelection();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        ArrayList<Produto> lista = produtoControle.listar();
        for (Produto p : lista) {
            tableModel.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getCategoria(),
                p.getPreco(),
                p.getQuantEstoque()
            });
        }
    }
}