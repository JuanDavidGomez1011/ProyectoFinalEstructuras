package vistas;

import javax.swing.*;

public class EmparejarJugador extends JFrame {

    private JPanel panel1;
    private JButton EmparejarButton;
    private JButton regresarButton;

    public EmparejarJugador() {

        setTitle("Emparejar Jugadores");
        setContentPane(panel1);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        EmparejarButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Jugadores emparejados correctamente."));

        regresarButton.addActionListener(e -> dispose());
    }
}