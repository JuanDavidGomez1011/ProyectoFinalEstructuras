package vistas;

import javax.swing.*;

public class Historial extends JFrame {

    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;

    public Historial() {

        setTitle("Historial");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        actualizarButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Historial actualizado correctamente."));

        regresarButton.addActionListener(e -> dispose());
    }
}