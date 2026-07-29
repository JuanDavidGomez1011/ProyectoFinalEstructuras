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
    private JTextArea txtArea;

    public ColaEspera(ColaJugadores cola) {
        this.cola = cola;
        setTitle("Cola de Espera");
        setContentPane(panel1);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtArea = new JTextArea();
        txtArea.setEditable(false);

        boolean encontradoEnForm = false;
        for (java.awt.Component comp : panel1.getComponents()) {
            if (comp instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) comp;
                if (scroll.getViewport().getView() instanceof JTextArea) {
                    txtArea = (JTextArea) scroll.getViewport().getView();
                    encontradoEnForm = true;
                    break;
                }
            }
        }

        if (!encontradoEnForm) {
            panel1.setLayout(new BorderLayout());
            panel1.add(new JScrollPane(txtArea), BorderLayout.CENTER);
            panel1.revalidate();
        }

        cargarCola();

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarCola());
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarCola() {
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