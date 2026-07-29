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

        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cédula.");
            return false;
        }

        if (principal.arbolRanking.buscar(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un jugador con esa cédula.");
            return false;
        }

        Jugador nuevoJugador = new Jugador(nombre, cedula);

        principal.arbolRanking.insertar(nuevoJugador);
        principal.colaEspera.enqueue(nuevoJugador);

        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente.");

        return true;
    }

    public boolean retirar(String cedula) {

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