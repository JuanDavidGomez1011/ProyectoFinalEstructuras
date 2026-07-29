package vistas;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;
import modelo.Jugador;

import javax.swing.*;

public class EmparejarJugador extends JFrame {

    private JPanel panel1;
    private JButton EmparejarButton;
    private JButton regresarButton;

    private ColaJugadores cola;
    private ArbolRankings arbol;
    private ListaPartidas historial;

    public EmparejarJugador(ColaJugadores cola,
                            ArbolRankings arbol,
                            ListaPartidas historial) {

        this.cola = cola;
        this.arbol = arbol;
        this.historial = historial;

        setTitle("Emparejar Jugadores");
        setContentPane(panel1);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        EmparejarButton.addActionListener(e -> emparejar());

        regresarButton.addActionListener(e -> dispose());
    }

    private void emparejar() {

        if (cola.size() < 2) {
            JOptionPane.showMessageDialog(this,
                    "No hay suficientes jugadores para emparejar.");
            return;
        }

        Jugador jugador1 = cola.dequeue();
        Jugador jugador2 = cola.dequeue();

        JOptionPane.showMessageDialog(this,
                "Partida:\n\n"
                        + jugador1.nombre + " VS " + jugador2.nombre);

        RegistrarResultado ventana =
                new RegistrarResultado(
                        jugador1,
                        jugador2,
                        arbol,
                        historial
                );

        ventana.setVisible(true);

        dispose();
    }
}