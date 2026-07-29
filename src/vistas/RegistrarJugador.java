package vistas;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import modelo.Jugador;

import javax.swing.*;

public class RegistrarJugador extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton registrarButton;
    private JButton limpiarButton;
    private JButton regresarButton;

    private ColaJugadores cola;
    private ArbolRankings arbol;

    public RegistrarJugador(ColaJugadores cola, ArbolRankings arbol) {

        this.cola = cola;
        this.arbol = arbol;

        setTitle("Registrar Jugador");
        setContentPane(panel1);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        registrarButton.addActionListener(e -> {

            String nombre = textField1.getText().trim();
            String cedula = textField2.getText().trim();

            if (nombre.isEmpty() || cedula.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos.");
                return;
            }

            if (arbol.buscar(cedula) != null) {
                JOptionPane.showMessageDialog(this,
                        "La cédula ya está registrada.");
                return;
            }

            Jugador jugador = new Jugador(nombre, cedula);

            cola.enqueue(jugador);
            arbol.insertar(jugador);

            JOptionPane.showMessageDialog(this,
                    "Jugador registrado correctamente.");

            textField1.setText("");
            textField2.setText("");
        });

        limpiarButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
        });

        regresarButton.addActionListener(e -> dispose());
    }
}