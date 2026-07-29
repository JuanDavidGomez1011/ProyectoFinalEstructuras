package vistas;

import estructuras.ArbolRankings;

import javax.swing.*;

public class Ranking extends JFrame {

    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;

    private ArbolRankings arbol;

    public Ranking(ArbolRankings arbol) {

        this.arbol = arbol;

        setTitle("Ranking");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        actualizarButton.addActionListener(e -> mostrarRanking());

        regresarButton.addActionListener(e -> dispose());
    }

    private void mostrarRanking() {

        String ranking = arbol.obtenerRanking();

        if (ranking.isEmpty()) {
            ranking = "No hay jugadores registrados.";
        }

        JOptionPane.showMessageDialog(
                this,
                ranking,
                "Ranking de Jugadores",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}