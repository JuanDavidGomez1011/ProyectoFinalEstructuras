package vistas;

import javax.swing.*;

public class RegistrarResultado extends JFrame {

    private JPanel panelPrincipal;
    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JRadioButton rbJugador1;
    private JRadioButton rbJugador2;
    private JRadioButton rbEmpate;
    private JButton btnGuardar;
    private JButton btnRegresar;

    public RegistrarResultado() {

        setTitle("Registrar Resultado");
        setContentPane(panelPrincipal);
        setSize(450,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnRegresar.addActionListener(e -> dispose());

        btnGuardar.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Resultado registrado correctamente."));
    }
}