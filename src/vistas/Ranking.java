package vistas;

import estructuras.ArbolRankings;
import estructuras.NodoArbol;
import javax.swing.*;
import java.awt.*;

public class Ranking extends JFrame {
    private JPanel panel1;
    private JButton actualizarButton;
    private JButton regresarButton;
    private ArbolRankings arbol;

    public Ranking(ArbolRankings arbol) {
        this.arbol = arbol;
        setTitle("Ranking de Jugadores");
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

        cargarRanking(txtArea);

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarRanking(txtArea));
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarRanking(JTextArea txtArea) {
        if (arbol.raiz == null) {
            txtArea.setText("No hay jugadores registrados.");
        } else {
            txtArea.setText("");
            mostrarRanking(arbol.raiz, txtArea);
        }
    }

    private void mostrarRanking(NodoArbol nodo, JTextArea ta) {
        if (nodo != null) {
            mostrarRanking(nodo.derecho, ta);
            ta.append("Jugador: " + nodo.jugador.nombre + " - Puntaje: " + nodo.jugador.puntaje + "\n");
            mostrarRanking(nodo.izquierdo, ta);
        }
    }
}