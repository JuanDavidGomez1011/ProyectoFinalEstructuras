package vistas;

import estructuras.ArbolRankings;
import estructuras.ListaPartidas;
import modelo.Jugador;
import modelo.Partida;

import javax.swing.*;

public class RegistrarResultado extends JFrame {

    private JPanel panel1;
    private JButton registarButton;
    private JButton regresarButton;

    private Jugador jugador1;
    private Jugador jugador2;
    private ArbolRankings arbol;
    private ListaPartidas historial;

    public RegistrarResultado(Jugador jugador1,
                              Jugador jugador2,
                              ArbolRankings arbol,
                              ListaPartidas historial) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.arbol = arbol;
        this.historial = historial;

        setTitle("Registrar Resultado");
        setContentPane(panel1);
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        registarButton.addActionListener(e -> registrarResultado());

        regresarButton.addActionListener(e -> dispose());
    }

    private void registrarResultado() {

        String[] opciones = {
                jugador1.nombre,
                jugador2.nombre,
                "Empate"
        };

        String ganador = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el ganador:",
                "Resultado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (ganador == null)
            return;

        int extra1 = Integer.parseInt(JOptionPane.showInputDialog(
                "Puntos extra para " + jugador1.nombre));

        int extra2 = Integer.parseInt(JOptionPane.showInputDialog(
                "Puntos extra para " + jugador2.nombre));

        Jugador ganadorJugador = null;

        if (ganador.equals(jugador1.nombre)) {

            ganadorJugador = jugador1;

            jugador1.puntaje += 3 + extra1;
            jugador2.puntaje += extra2;

        } else if (ganador.equals(jugador2.nombre)) {

            ganadorJugador = jugador2;

            jugador2.puntaje += 3 + extra2;
            jugador1.puntaje += extra1;

        } else {

            jugador1.puntaje += 1 + extra1;
            jugador2.puntaje += 1 + extra2;
        }

        arbol.actualizarPuntaje(jugador1, jugador1.puntaje);
        arbol.actualizarPuntaje(jugador2, jugador2.puntaje);

        Partida partida = new Partida(
                jugador1,
                jugador2,
                ganadorJugador,
                ganador,
                extra1,
                extra2
        );

        historial.insertar(partida);

        JOptionPane.showMessageDialog(this,
                "Resultado registrado correctamente.");

        dispose();
    }
}