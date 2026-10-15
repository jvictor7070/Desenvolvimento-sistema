package view;

import controle.ProdutoControle;
import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Produto;

public class ProdutoView extends JFrame {

    // Objeto responsável pela comunicação com o controle
    private final ProdutoControle controle = new ProdutoControle();

    // Componentes da interface
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtPreco;

    private JButton btnCadastrar;
    private JButton btnBuscar;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnListar;
    private JButton btnLimpar;

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    // Construtor da interface
    public ProdutoView() {

        setTitle("Gerenciamento de Produtos");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        criarInterface();
        configurarEventos();
        atualizarTabela();
    }

    // Cria todos os componentes da interface
    private void criarInterface() {

        // Título
        JLabel titulo = new JLabel(
                "GERENCIAMENTO DE PRODUTOS",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(30, 60, 100));
        titulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        add(titulo, BorderLayout.NORTH);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        add(painelPrincipal, BorderLayout.CENTER);

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridBagLayout());

        painelCadastro.setBorder(
                BorderFactory.createTitledBorder("Dados do Produto")
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Código
        gbc.gridx = 0;
        gbc.gridy = 0;

        painelCadastro.add(new JLabel("Código:"), gbc);

        txtCodigo = new JTextField(15);

        gbc.gridx = 1;
        painelCadastro.add(txtCodigo, gbc);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 1;

        painelCadastro.add(new JLabel("Nome:"), gbc);

        txtNome = new JTextField(25);

        gbc.gridx = 1;
        painelCadastro.add(txtNome, gbc);

        // Preço
        gbc.gridx = 0;
        gbc.gridy = 2;

        painelCadastro.add(new JLabel("Preço:"), gbc);

        txtPreco = new JTextField(15);

        gbc.gridx = 1;
        painelCadastro.add(txtPreco, gbc);

        painelPrincipal.add(painelCadastro, BorderLayout.NORTH);

        // Tabela de produtos
        modeloTabela = new DefaultTableModel(
                new Object[]{"Código", "Nome", "Preço"}, 0
        ) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        tabela = new JTable(modeloTabela);
        tabela.setRowHeight(25);

        tabela.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tabela);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Produtos Cadastrados"
                )
        );

        painelPrincipal.add(scroll, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout());

        btnCadastrar = new JButton("Cadastrar");
        btnBuscar = new JButton("Buscar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnListar = new JButton("Listar");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnLimpar);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }

    // Configura os eventos dos botões e da tabela
    private void configurarEventos() {

        btnCadastrar.addActionListener(e -> cadastrar());

        btnBuscar.addActionListener(e -> buscar());

        btnAlterar.addActionListener(e -> alterar());

        btnExcluir.addActionListener(e -> excluir());

        btnListar.addActionListener(e -> atualizarTabela());

        btnLimpar.addActionListener(e -> limparCampos());

        // Preenche os campos ao selecionar um produto
        tabela.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()
                    && tabela.getSelectedRow() != -1) {

                int linha = tabela.convertRowIndexToModel(
                        tabela.getSelectedRow()
                );

                txtCodigo.setText(
                        modeloTabela.getValueAt(linha, 0).toString()
                );

                txtNome.setText(
                        modeloTabela.getValueAt(linha, 1).toString()
                );

                txtPreco.setText(
                        modeloTabela.getValueAt(linha, 2)
                                .toString().replace(',', '.')
                );
            }
        });
    }

    // CADASTRAR PRODUTO
    private void cadastrar() {

        try {

            int codigo = lerCodigo();
            String nome = lerNome();
            double preco = lerPreco();

            // Verifica se o código já está cadastrado
            if (controle.buscar(codigo) != null) {

                mostrarMensagem("Código já cadastrado!");
                return;
            }

            // Envia os dados ao controle
            controle.cadastrar(codigo, nome, preco);

            mostrarMensagem("Produto cadastrado com sucesso!");

            atualizarTabela();
            limparCampos();

        } catch (IllegalArgumentException ex) {

            mostrarErro(ex.getMessage());
        }
    }

    // BUSCAR PRODUTO
    private void buscar() {

        try {

            int codigo = lerCodigo();

            Produto produto = controle.buscar(codigo);

            if (produto != null) {

                txtNome.setText(produto.getNome());

                txtPreco.setText(
                        String.valueOf(produto.getPreco())
                );

                mostrarMensagem("Produto encontrado!");

            } else {

                mostrarMensagem("Produto não encontrado!");
            }

        } catch (IllegalArgumentException ex) {

            mostrarErro(ex.getMessage());
        }
    }

    // ALTERAR PRODUTO
    private void alterar() {

        try {

            int codigo = lerCodigo();
            String nome = lerNome();
            double preco = lerPreco();

            boolean alterado = controle.alterar(
                    codigo, nome, preco
            );

            if (alterado) {

                mostrarMensagem("Produto alterado com sucesso!");

                atualizarTabela();
                limparCampos();

            } else {

                mostrarMensagem("Produto não encontrado!");
            }

        } catch (IllegalArgumentException ex) {

            mostrarErro(ex.getMessage());
        }
    }

    // EXCLUIR PRODUTO
    private void excluir() {

        try {

            int codigo = lerCodigo();

            Produto produto = controle.buscar(codigo);

            if (produto == null) {

                mostrarMensagem("Produto não encontrado!");
                return;
            }

            int opcao = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir o produto?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcao == JOptionPane.YES_OPTION) {

                boolean removido = controle.remover(codigo);

                if (removido) {

                    mostrarMensagem(
                            "Produto excluído com sucesso!"
                    );

                    atualizarTabela();
                    limparCampos();
                }
            }

        } catch (IllegalArgumentException ex) {

            mostrarErro(ex.getMessage());
        }
    }

    // LISTAR PRODUTOS NA TABELA
    private void atualizarTabela() {

        // Remove todas as linhas da tabela
        modeloTabela.setRowCount(0);

        // Percorre os produtos cadastrados
        for (Produto produto : controle.listar()) {

            modeloTabela.addRow(new Object[]{

                    produto.getCodigo(),
                    produto.getNome(),

                    String.format(
                            Locale.forLanguageTag("pt-BR"),
                            "%.2f",
                            produto.getPreco()
                    )
            });
        }
    }

    // LIMPAR CAMPOS
    private void limparCampos() {

        tabela.clearSelection();

        txtCodigo.setText("");
        txtNome.setText("");
        txtPreco.setText("");

        txtCodigo.requestFocusInWindow();
    }

    // VALIDAR CÓDIGO
    private int lerCodigo() {

        try {

            int codigo = Integer.parseInt(
                    txtCodigo.getText().trim()
            );

            if (codigo <= 0) {

                throw new NumberFormatException();
            }

            return codigo;

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                    "Informe um código inteiro positivo!"
            );
        }
    }

    // VALIDAR NOME
    private String lerNome() {

        String nome = txtNome.getText().trim();

        if (nome.isEmpty()) {

            throw new IllegalArgumentException(
                    "Informe o nome do produto!"
            );
        }

        return nome;
    }

    // VALIDAR PREÇO
    private double lerPreco() {

        try {

            double preco = Double.parseDouble(
                    txtPreco.getText()
                            .trim()
                            .replace(',', '.')
            );

            if (!Double.isFinite(preco) || preco < 0) {

                throw new NumberFormatException();
            }

            return preco;

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                    "Informe um preço válido!"
            );
        }
    }

    // MENSAGEM DE SUCESSO OU INFORMAÇÃO
    private void mostrarMensagem(String mensagem) {

        JOptionPane.showMessageDialog(
                this,
                mensagem,
                "Informação",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // MENSAGEM DE ERRO
    private void mostrarErro(String mensagem) {

        JOptionPane.showMessageDialog(
                this,
                mensagem,
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // MÉTODO PRINCIPAL
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ProdutoView tela = new ProdutoView();

            tela.setVisible(true);
        });
    }
}