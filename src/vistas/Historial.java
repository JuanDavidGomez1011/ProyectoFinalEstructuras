package vistas;

import estructuras.ListaPartidas;
import estructuras.NodoLista;
import javax.swing.*;
import java.awt.*;

public class Historial extends JFrame {
    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;
    private ListaPartidas historial;
    private JTextArea txtArea;

    public Historial(ListaPartidas historial) {
        this.historial = historial;
        setTitle("Historial de Partidas");
        setContentPane(panel1);
        setSize(500, 400);
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

        cargarHistorial();

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarHistorial());
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarHistorial() {
        NodoLista actual = historial.primero;
        if (actual == null) {
            txtArea.setText("No hay partidas registradas.");
        } else {
            txtArea.setText("");
            while(actual != null) {
                txtArea.append(actual.partida.jugador1.nombre + " VS " + actual.partida.jugador2.nombre +
                        " | Resultado: " + actual.partida.resultado + "\n");
                actual = actual.siguiente;
            }
        }
    }
}