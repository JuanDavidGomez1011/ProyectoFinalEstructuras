package vistas;

import javax.swing.*;

public class Ranking extends JFrame {

    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;

    public Ranking() {

        setTitle("Ranking");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        actualizarButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Ranking actualizado."));

        regresarButton.addActionListener(e -> dispose());
    }
}