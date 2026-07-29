package controladores;

import modelo.Jugador;
import modelo.Partida;

public class PartidaController {

    public PrincipalController principal;

    public PartidaController(PrincipalController principal) {
        this.principal = principal;
    }

    public void registrarPartida(String resultado, int extraJugador1, int extraJugador2) {

        Jugador j1 = principal.colaEspera.dequeue();
        Jugador j2 = principal.colaEspera.dequeue();

        if (j1 != null && j2 != null) {

            principal.arbolRanking.eliminar(j1);
            principal.arbolRanking.eliminar(j2);

            Jugador ganador = null;

            if (resultado.equals("Victoria")) {
                j1.puntaje += 20;
                j2.puntaje -= 10;
                ganador = j1;
            } else if (resultado.equals("Derrota")) {
                j1.puntaje -= 10;
                j2.puntaje += 20;
                ganador = j2;
            }

            j1.puntaje += extraJugador1;
            j2.puntaje += extraJugador2;

            principal.arbolRanking.insertar(j1);
            principal.arbolRanking.insertar(j2);

            Partida nuevaPartida = new Partida(
                    j1,
                    j2,
                    ganador,
                    resultado,
                    extraJugador1 + extraJugador2
            );

            principal.historialPartidas.insertar(nuevaPartida);
        }
    }

    public void anularPartida(Partida partida) {

        principal.historialPartidas.eliminar(partida);

        principal.arbolRanking.eliminar(partida.jugador1);
        principal.arbolRanking.eliminar(partida.jugador2);

        if (partida.resultado.equals("Victoria")) {
            partida.jugador1.puntaje -= 20;
            partida.jugador2.puntaje += 10;
        } else if (partida.resultado.equals("Derrota")) {
            partida.jugador1.puntaje += 10;
            partida.jugador2.puntaje -= 20;
        }

        principal.arbolRanking.insertar(partida.jugador1);
        principal.arbolRanking.insertar(partida.jugador2);
    }
}