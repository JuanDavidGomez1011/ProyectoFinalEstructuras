package controladores;

import modelo.Jugador;

public class JugadorController {
    public PrincipalController principal;

    public JugadorController(PrincipalController principal) {
        this.principal = principal;
    }

    public void inscribir(String nombre, String cedula) {
        Jugador nuevoJugador = new Jugador(nombre, cedula);
        principal.arbolRanking.insertar(nuevoJugador);
        principal.colaEspera.enqueue(nuevoJugador);
    }

    public void retirar(String cedula) {
        Jugador jugador = principal.arbolRanking.buscar(cedula);
        if (jugador != null) {
            principal.arbolRanking.eliminar(jugador);
        }
    }
}