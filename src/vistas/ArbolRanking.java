package vistas;

import estructuras.ArbolRankings;
import javax.swing.*;

public class ArbolRanking extends JFrame {

    private JPanel panel1;
    private JButton mostarButton;
    private JButton regresarButton;
    private ArbolRankings arbol;

    public ArbolRanking(ArbolRankings arbol) {
        this.arbol = arbol;

        setTitle("Árbol de Ranking");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        mostarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, arbol.obtenerRanking());
        });

        regresarButton.addActionListener(e -> dispose());
    }
}