package vistas;

import estructuras.ColaJugadores;

import javax.swing.*;

public class ColaEspera extends JFrame {

    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;

    private ColaJugadores cola;

    public ColaEspera(ColaJugadores cola) {

        this.cola = cola;

        setTitle("Cola de Espera");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        actualizarButton.addActionListener(e -> mostrarCola());

        regresarButton.addActionListener(e -> dispose());
    }

    private void mostrarCola() {

        String texto = cola.mostrarCola();

        JOptionPane.showMessageDialog(
                this,
                texto,
                "Jugadores en Espera",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}