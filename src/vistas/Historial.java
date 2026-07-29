package vistas;

import estructuras.ListaPartidas;

import javax.swing.*;

public class Historial extends JFrame {

    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;

    private ListaPartidas historial;

    public Historial(ListaPartidas historial) {

        this.historial = historial;

        setTitle("Historial");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        actualizarButton.addActionListener(e -> mostrarHistorial());

        regresarButton.addActionListener(e -> dispose());
    }

    private void mostrarHistorial() {

        String texto = historial.mostrarHistorial();

        JOptionPane.showMessageDialog(
                this,
                texto,
                "Historial de Partidas",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}