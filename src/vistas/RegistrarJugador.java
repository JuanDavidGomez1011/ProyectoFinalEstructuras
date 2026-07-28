package vistas;

import javax.swing.*;

public class RegistrarJugador extends JFrame {

    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private JButton btnRegresar;

    public RegistrarJugador() {

        setTitle("Registrar Jugador");
        setContentPane(panelPrincipal);
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnRegistrar.addActionListener(e -> {

            String nombre = txtNombre.getText().trim();
            String cedula = txtCedula.getText().trim();

            if(nombre.isEmpty() || cedula.isEmpty()){

                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos.");

                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Jugador registrado correctamente.");

        });

        btnLimpiar.addActionListener(e -> {
            txtNombre.setText("");
            txtCedula.setText("");
        });

        btnRegresar.addActionListener(e -> dispose());

    }
}
