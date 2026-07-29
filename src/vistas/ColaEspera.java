package vistas;

import estructuras.ColaJugadores;
import estructuras.NodoCola;
import javax.swing.*;
import java.awt.*;

public class ColaEspera extends JFrame {
    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;
    private ColaJugadores cola;

    public ColaEspera(ColaJugadores cola) {
        this.cola = cola;
        setTitle("Cola de Espera");
        setContentPane(panel1);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea txtArea = new JTextArea();
        txtArea.setEditable(false);

        if (panel1.getComponentCount() == 0) {
            panel1.setLayout(new BorderLayout());
            panel1.add(new JScrollPane(txtArea), BorderLayout.CENTER);
        }

        cargarCola(txtArea);

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarCola(txtArea));
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarCola(JTextArea txtArea) {
        NodoCola actual = cola.frente;
        if (actual == null) {
            txtArea.setText("La cola está vacía.");
        } else {
            txtArea.setText("");
            int pos = 1;
            while(actual != null) {
                txtArea.append(pos + ". " + actual.jugador.nombre + " (C.C: " + actual.jugador.cedula + ")\n");
                actual = actual.siguiente;
                pos++;
            }
        }
    }
}