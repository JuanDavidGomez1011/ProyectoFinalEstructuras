package vistas;

import javax.swing.*;

public class RegistrarResultado extends JFrame {

    private JPanel panel1;
    private JButton registarButton;
    private JButton regresarButton;

    public RegistrarResultado() {

        setTitle("Registrar Resultado");
        setContentPane(panel1);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        registarButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Resultado registrado correctamente."));

        regresarButton.addActionListener(e -> dispose());
    }
}