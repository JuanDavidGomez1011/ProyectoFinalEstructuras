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

    public Historial(ListaPartidas historial) {
        this.historial = historial;
        setTitle("Historial de Partidas");
        setContentPane(panel1);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea txtArea = new JTextArea();
        txtArea.setEditable(false);

        if (panel1.getComponentCount() == 0) {
            panel1.setLayout(new BorderLayout());
            panel1.add(new JScrollPane(txtArea), BorderLayout.CENTER);
        }

        cargarHistorial(txtArea);

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarHistorial(txtArea));
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarHistorial(JTextArea txtArea) {
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