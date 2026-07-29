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
    private JTextArea txtArea;

    public Ranking(ArbolRankings arbol) {
        this.arbol = arbol;
        setTitle("Ranking de Jugadores");
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

        cargarRanking();

        if (actualizarButton != null) {
            actualizarButton.addActionListener(e -> cargarRanking());
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }

    private void cargarRanking() {
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