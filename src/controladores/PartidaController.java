package controladores;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;
import modelo.Jugador;
import modelo.Partida;

public class PartidaController {

    private ColaJugadores cola;
    private ArbolRankings arbol;
    private ListaPartidas historial;

    public PartidaController(ColaJugadores cola, ArbolRankings arbol, ListaPartidas historial) {
        this.cola = cola;
        this.arbol = arbol;
        this.historial = historial;
    }

    public void registrarPartida(Jugador jugador1, Jugador jugador2, String resultado, int extra1, int extra2) {
        arbol.eliminar(jugador1);
        arbol.eliminar(jugador2);

        Jugador ganadorJugador = null;

        if (resultado.contains("Victoria")) {
            if (resultado.contains(jugador1.nombre)) {
                ganadorJugador = jugador1;
                jugador1.puntaje += 3 + extra1;
                jugador2.puntaje += extra2;
            } else {
                ganadorJugador = jugador2;
                jugador2.puntaje += 3 + extra2;
                jugador1.puntaje += extra1;
            }
        } else {
            jugador1.puntaje += 1 + extra1;
            jugador2.puntaje += 1 + extra2;
        }

        arbol.insertar(jugador1);
        arbol.insertar(jugador2);

        Partida nuevaPartida = new Partida(
                jugador1,
                jugador2,
                ganadorJugador,
                resultado,
                extra1,
                extra2
        );

        historial.insertar(nuevaPartida);
    }
}