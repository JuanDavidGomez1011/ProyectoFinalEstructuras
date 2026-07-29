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
        if (cedula == null) {
            JOptionPane.showMessageDialog(null, "La cédula es demasiado corta.");
            return false;
        }

        int longitudCedula = 0;
        for (int i = 0; i < cedula.length(); i++) {
            longitudCedula++;
        }

        if (longitudCedula < 5) {
            JOptionPane.showMessageDialog(null, "La cédula es demasiado corta.");
            return false;
        }

        if (arbol.buscar(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un jugador con esa cédula.");
            return false;
        }

        String nombreLimpio = "";
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (!(i == 0 && c == ' ') && !(i == nombre.length() - 1 && c == ' ')) {
                nombreLimpio += c;
            }
        }

        String cedulaLimpia = "";
        for (int i = 0; i < cedula.length(); i++) {
            char c = cedula.charAt(i);
            if (!(i == 0 && c == ' ') && !(i == cedula.length() - 1 && c == ' ')) {
                cedulaLimpia += c;
            }
        }

        Jugador nuevoJugador = new Jugador(nombreLimpio, cedulaLimpia);
        arbol.insertar(nuevoJugador);
        cola.enqueue(nuevoJugador);

        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente.");
        return true;
    }

    public boolean retirar(String cedula) {
        if (cedula == null) {
            return false;
        }

        boolean esVacia = true;
        for (int i = 0; i < cedula.length(); i++) {
            if (cedula.charAt(i) != ' ') {
                esVacia = false;
                break;
            }
        }

        if (esVacia) {
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