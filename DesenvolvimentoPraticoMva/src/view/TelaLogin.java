package view;

import controller.UsuarioControle;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private UsuarioControle usuarioControle;

    public TelaLogin() {
        usuarioControle = new UsuarioControle();
        
        // Regista um utilizador padrão caso ainda não exista nenhum no DAO
        if (usuarioControle.buscar("admin") == null) {
            usuarioControle.cadastrar("admin", "1234");
        }
        
        initComponents();
    }

    private void initComponents() {
        setTitle("Acesso ao Sistema - Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Utilizador:"), gbc);

        txtUsuario = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Palavra-passe:"), gbc);

        txtSenha = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtSenha, gbc);

        btnEntrar = new JButton("Entrar");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(btnEntrar, gbc);

        add(panel);

        // Ação do botão Entrar
        btnEntrar.addActionListener(e -> efetuarLogin());
    }

    private void efetuarLogin() {
        String usuarioInput = txtUsuario.getText().trim();
        String senhaInput = new String(txtSenha.getPassword()).trim();

        Usuario u = usuarioControle.buscar(usuarioInput);

        if (u != null && u.getSenha().equals(senhaInput)) {
            JOptionPane.showMessageDialog(this, "Login efetuado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            new TelaProduto().setVisible(true);
            this.dispose(); // Fecha o ecrã de login
        } else {
            JOptionPane.showMessageDialog(this, "Utilizador ou palavra-passe incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }
}