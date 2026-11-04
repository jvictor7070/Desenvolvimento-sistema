package com.example;

import javax.swing.SwingUtilities;

/**
 * Classe Principal para iniciar a aplicação.
 */
public class EletroDomesticos {

    public static void main(String[] args) {
        // Executa a interface gráfica na thread do Swing por boas práticas
        SwingUtilities.invokeLater(() -> {
            EletrodomesticoView view = new EletrodomesticoView();
            view.iniciarMenu();
        });
    }
}