package vistas;

import javax.swing.*;

public class EmparejarJugadores extends JFrame {

    private JPanel panelPrincipal;
    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JButton btnEmparejar;
    private JButton btnRegresar;

    public EmparejarJugadores() {

        setTitle("Emparejar Jugadores");
        setContentPane(panelPrincipal);
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnEmparejar.addActionListener(e -> {

            String jugador1 = txtJugador1.getText().trim();
            String jugador2 = txtJugador2.getText().trim();

            if(jugador1.isEmpty() || jugador2.isEmpty()){

                JOptionPane.showMessageDialog(this,
                        "Ingrese los dos jugadores.");

                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Emparejamiento realizado correctamente.");

        });

        btnRegresar.addActionListener(e -> dispose());

    }
}