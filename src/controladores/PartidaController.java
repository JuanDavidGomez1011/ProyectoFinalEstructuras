package controladores;

import javax.swing.JOptionPane;
import modelo.Jugador;
import modelo.Partida;

public class PartidaController {

    public PrincipalController principal;

    public PartidaController(PrincipalController principal) {
        this.principal = principal;
    }

    public void registrarPartida(String resultado, int extraJugador1, int extraJugador2) {

        if (principal.colaEspera.size() < 2) {
            JOptionPane.showMessageDialog(null, "Se necesitan al menos dos jugadores.");
            return;
        }

        if (resultado == null || resultado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un resultado.");
            return;
        }

        if (!resultado.equals("Victoria")
                && !resultado.equals("Derrota")
                && !resultado.equals("Empate")) {

            JOptionPane.showMessageDialog(null, "Resultado inválido.");
            return;
        }

        if (extraJugador1 < 0 || extraJugador2 < 0) {
            JOptionPane.showMessageDialog(null, "Los puntos extra no pueden ser negativos.");
            return;
        }

        Jugador j1 = principal.colaEspera.dequeue();
        Jugador j2 = principal.colaEspera.dequeue();

        if (j1 == null || j2 == null) {
            JOptionPane.showMessageDialog(null, "No hay suficientes jugadores.");
            return;
        }

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
                extraJugador1,
                extraJugador2
        );

        principal.historialPartidas.insertar(nuevaPartida);

        JOptionPane.showMessageDialog(null, "Partida registrada correctamente.");
    }

    public void anularPartida(Partida partida) {

        if (partida == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una partida.");
            return;
        }

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

        partida.jugador1.puntaje -= partida.puntosExtraJugador1;
        partida.jugador2.puntaje -= partida.puntosExtraJugador2;

        principal.arbolRanking.insertar(partida.jugador1);
        principal.arbolRanking.insertar(partida.jugador2);

        JOptionPane.showMessageDialog(null, "Partida anulada correctamente.");
    }
}