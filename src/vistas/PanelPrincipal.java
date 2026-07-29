package vistas;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;
import javax.swing.*;

public class PanelPrincipal extends JFrame {

    private JPanel panel1;
    private JButton registrarJugadorButton;
    private JButton emparejarJugadorButton;
    private JButton registrarResultadoButton;
    private JButton rankingButton;
    private JButton historialButton;
    private JButton colaDeEsperaButton;
    private JButton arbolDelRankingButton;
    private JButton salirButton;

    private ColaJugadores cola;
    private ArbolRankings arbol;
    private ListaPartidas historial;

    public PanelPrincipal() {
        cola = new ColaJugadores();
        arbol = new ArbolRankings();
        historial = new ListaPartidas();

        setTitle("Sistema de Gestión del Torneo de Ajedrez");
        setContentPane(panel1);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        registrarResultadoButton.setEnabled(false);

        registrarJugadorButton.addActionListener(e -> {
            RegistrarJugador ventana = new RegistrarJugador(cola, arbol);
            ventana.setVisible(true);
        });

        emparejarJugadorButton.addActionListener(e -> {
            EmparejarJugador ventana = new EmparejarJugador(cola, arbol, historial);
            ventana.setVisible(true);
        });

        rankingButton.addActionListener(e -> {
            Ranking ventana = new Ranking(arbol);
            ventana.setVisible(true);
        });

        historialButton.addActionListener(e -> {
            Historial ventana = new Historial(historial);
            ventana.setVisible(true);
        });

        colaDeEsperaButton.addActionListener(e -> {
            ColaEspera ventana = new ColaEspera(cola);
            ventana.setVisible(true);
        });

        arbolDelRankingButton.addActionListener(e -> {
            ArbolRanking ventana = new ArbolRanking(arbol);
            ventana.setVisible(true);
        });

        salirButton.addActionListener(e -> System.exit(0));
    }
}