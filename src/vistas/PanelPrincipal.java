package vistas;

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

    public PanelPrincipal() {

        setTitle("Sistema de Gestión del Torneo de Ajedrez");
        setContentPane(panel1);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        registrarJugadorButton.addActionListener(e -> {
            RegistrarJugador ventana = new RegistrarJugador();
            ventana.setVisible(true);
        });

        emparejarJugadorButton.addActionListener(e -> {
            EmparejarJugador ventana = new EmparejarJugador();
            ventana.setVisible(true);
        });

        registrarResultadoButton.addActionListener(e -> {
            RegistrarResultado ventana = new RegistrarResultado();
            ventana.setVisible(true);
        });

        rankingButton.addActionListener(e -> {
            Ranking ventana = new Ranking();
            ventana.setVisible(true);
        });

        historialButton.addActionListener(e -> {
            Historial ventana = new Historial();
            ventana.setVisible(true);
        });

        colaDeEsperaButton.addActionListener(e -> {
            ColaEspera ventana = new ColaEspera();
            ventana.setVisible(true);
        });

        arbolDelRankingButton.addActionListener(e -> {
            ArbolRanking ventana = new ArbolRanking();
            ventana.setVisible(true);
        });

        salirButton.addActionListener(e -> System.exit(0));
    }
}