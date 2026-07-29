package controladores;

import javax.swing.JOptionPane;
import modelo.Jugador;

public class JugadorController {

    private PrincipalController principal;

    public JugadorController(PrincipalController principal) {
        this.principal = principal;
    }

    public boolean inscribir(String nombre, String cedula) {

        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del jugador.");
            return false;
        }

        if (nombre.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El nombre no puede contener solo números.");
            return false;
        }

        if (nombre.trim().length() < 3) {
            JOptionPane.showMessageDialog(null, "El nombre debe tener al menos 3 caracteres.");
            return false;
        }

        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cédula.");
            return false;
        }

        if (!cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "La cédula solo debe contener números.");
            return false;
        }

        if (cedula.trim().length() < 5) {
            JOptionPane.showMessageDialog(null, "La cédula es demasiado corta.");
            return false;
        }

        if (principal.arbolRanking.buscar(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un jugador con esa cédula.");
            return false;
        }

        Jugador nuevoJugador = new Jugador(nombre.trim(), cedula.trim());

        principal.arbolRanking.insertar(nuevoJugador);
        principal.colaEspera.enqueue(nuevoJugador);

        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente.");

        return true;
    }

    public boolean retirar(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cédula.");
            return false;
        }

        if (!cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "La cédula debe contener solo números.");
            return false;
        }

        Jugador jugador = principal.arbolRanking.buscar(cedula);

        if (jugador == null) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
            return false;
        }

        principal.arbolRanking.eliminar(jugador);
        principal.colaEspera.eliminar(cedula);

        JOptionPane.showMessageDialog(null, "Jugador retirado correctamente.");

        return true;
    }
}