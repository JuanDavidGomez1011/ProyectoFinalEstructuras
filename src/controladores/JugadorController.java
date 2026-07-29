package controladores;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import modelo.Jugador;
import javax.swing.*;

public class JugadorController {

    private ColaJugadores cola;
    private ArbolRankings arbol;

    public JugadorController(ColaJugadores cola, ArbolRankings arbol) {
        this.cola = cola;
        this.arbol = arbol;
    }

    public boolean inscribir(String nombre, String cedula) {
        if (cedula == null || cedula.trim().length() < 5) {
            JOptionPane.showMessageDialog(null, "La cédula es demasiado corta.");
            return false;
        }

        if (arbol.buscar(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un jugador con esa cédula.");
            return false;
        }

        Jugador nuevoJugador = new Jugador(nombre.trim(), cedula.trim());
        arbol.insertar(nuevoJugador);
        cola.enqueue(nuevoJugador);

        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente.");
        return true;
    }

    public boolean retirar(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return false;
        }

        Jugador jugador = arbol.buscar(cedula);
        if (jugador != null) {
            arbol.eliminar(jugador);
            return true;
        }
        return false;
    }
}