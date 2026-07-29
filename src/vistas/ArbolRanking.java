package vistas;

import javax.swing.*;

public class ArbolRanking extends JFrame {

    private JPanel panel1;
    private JButton mostarButton;
    private JButton regresarButton;

    public ArbolRanking() {

        setTitle("Árbol de Ranking");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        mostarButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Árbol de ranking mostrado."
                )
        );

        regresarButton.addActionListener(e -> dispose());
    }
}