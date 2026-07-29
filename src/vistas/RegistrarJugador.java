package vistas;

import controladores.JugadorController;
import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import javax.swing.*;

public class RegistrarJugador extends JFrame {

    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField txtCedula;
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
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        if (registrarButton != null) {
            registrarButton.addActionListener(e -> {
                String nombre = txtNombre.getText().trim();
                String cedula = txtCedula.getText().trim();

                if(nombre.isEmpty() || cedula.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                    return;
                }

                JugadorController jc = new JugadorController(cola, arbol);
                boolean registrado = jc.inscribir(nombre, cedula);

                if(registrado) {
                    txtNombre.setText("");
                    txtCedula.setText("");
                }
            });
        }

        if (limpiarButton != null) {
            limpiarButton.addActionListener(e -> {
                txtNombre.setText("");
                txtCedula.setText("");
            });
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> dispose());
        }
    }
}