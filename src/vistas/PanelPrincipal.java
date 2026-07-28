package vistas;

import javax.swing.*;

public class PanelPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JButton registrarJugadorButton;
    private JButton emparejarJugadoresButton;
    private JButton registrarResultadoButton;
    private JButton rankingButton;
    private JButton historialButton;
    private JButton colaDeEsperaButton;
    private JButton arbolDeRankingButton;
    private JButton salirButton;

    public PanelPrincipal() {

        setTitle("Sistema de Gestión del Torneo de Ajedrez");
        setContentPane(panelPrincipal);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Abrir Registrar Jugador
        registrarJugadorButton.addActionListener(e -> {
            RegistrarJugador ventana = new RegistrarJugador();
            ventana.setVisible(true);
        });

        // Abrir Emparejar Jugadores
        emparejarJugadoresButton.addActionListener(e -> {
            EmparejarJugadores ventana = new EmparejarJugadores();
            ventana.setVisible(true);
        });

        // Abrir Registrar Resultado
        registrarResultadoButton.addActionListener(e -> {
            RegistrarResultado ventana = new RegistrarResultado();
            ventana.setVisible(true);
        });

    }
}